package com.bloom.gops.core.config;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.bloom.gops.core.common.utils.JsonUtils;
import com.bloom.gops.core.common.utils.RequestUtils;
import com.google.common.collect.Lists;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

@Component
@Aspect
public class HttpMethodInterceptor {

    private static final Logger REST_LOGGER = LoggerFactory.getLogger("rest");
    private static final Logger EMAIL_LOGGER = LoggerFactory.getLogger("emailnotify");

    @Autowired(required = false)
    private HttpServletRequest request;

    @Pointcut("execution(* com.wedoctor.commerce.werp.hr.controller..*Controller.*(..))")
    public void controllerOperation() {
    }

    @Around("controllerOperation()")
    public Object invoke(ProceedingJoinPoint pjp) throws Throwable {

        // 开始时间
        long startTime = System.currentTimeMillis();
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setClientIp(RequestUtils.getRemoteHost(request));
        String url = request.getRequestURL().toString();
        Object[] objectArray = pjp.getArgs();

        List<Object> objectList = Lists.newArrayList();
        if (ArrayUtils.isNotEmpty(objectArray)) {
            for (Object o : objectArray) {
                if (o instanceof ExtendedServletRequestDataBinder) {
                    ExtendedServletRequestDataBinder extendedServletRequestDataBinder = (ExtendedServletRequestDataBinder) o;
                    objectList.add(extendedServletRequestDataBinder.getTarget());
                } else if (o instanceof ServletResponse) {
                    objectList.add("ServletResponse对象");
                } else if (o instanceof MultipartFile) {
                    objectList.add("MultipartFile对象");
                } else {
                    objectList.add(o);
                }
            }
        }
        requestInfo.setParams(objectList);
        requestInfo.setMethodName(url);
        requestInfo.setHeadMap(getHeadersInfo());
        try {
            // 执行操作
            Object result = pjp.proceed();
            printSuccessLog(requestInfo, startTime, result);
            return result;
        } catch (Exception e) {
            REST_LOGGER.error("调用http接口报错,request={}", JsonUtils.toJson(requestInfo), e);
            sendmail(requestInfo, e);
            throw e;
        }
    }

    private void sendmail(RequestInfo requestInfo, Exception e) {
        EMAIL_LOGGER.error("调用http接口报错,request={}", JsonUtils.toJson(requestInfo), e);
    }

    private void printSuccessLog(RequestInfo logModel, long startTime, Object result) {
        logModel.setFlag(0);
        long endTime = System.currentTimeMillis();
        // 执行结束时间
        logModel.setExecuteTime(endTime - startTime);
        logModel.setResult(result);
        if (Objects.nonNull(result)) {
            REST_LOGGER.info("http请求成功:{}", JsonUtils.toJson(logModel));
        }
    }

    private Map<String, String> getHeadersInfo() {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
