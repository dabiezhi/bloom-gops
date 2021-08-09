/*
 * Copyright (c) 2001-2021 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.config;

import com.bloom.gops.core.beetl.CustomBeetlGroupUtilConfiguration;
import com.bloom.gops.core.beetl.expander.BeetlConfigExpander;

import java.util.Properties;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeetlConfiguration {

    @Value("${spring.mvc.view.prefix}")
    private String prefix;
    @Value("${beetl.resource-auto-check}")
    private String resourceAutoCheck;

    /**
     * Beetl的自定义配置
     *
     * @author fengshuonan
     * @date 2020/12/27 12:34
     */
    @Bean(initMethod = "init")
    public CustomBeetlGroupUtilConfiguration customBeetlGroupUtilConfiguration() {
        CustomBeetlGroupUtilConfiguration customBeetlGroupUtilConfiguration = new CustomBeetlGroupUtilConfiguration();

        // 设置beetl的资源加载器
        customBeetlGroupUtilConfiguration
            .setResourceLoader(new ClasspathResourceLoader(BeetlConfiguration.class.getClassLoader(), prefix));

        // 设置beetl的配置
        customBeetlGroupUtilConfiguration.setConfigProperties(createBeetlProperties());

        return customBeetlGroupUtilConfiguration;
    }

    /**
     * beetl的视图解析器
     *
     * @author fengshuonan
     * @date 2020/12/27 12:34
     */
    @Bean
    public BeetlSpringViewResolver beetlViewResolver(
        CustomBeetlGroupUtilConfiguration customBeetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setConfig(customBeetlGroupUtilConfiguration);
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        return beetlSpringViewResolver;
    }

    /**
     * 组装beetl初始化需要的properties
     *
     * @author fengshuonan
     * @date 2020/12/27 12:33
     */
    private Properties createBeetlProperties() {
        Properties properties = new Properties();
        properties.setProperty("DELIMITER_STATEMENT_START", BeetlConfigExpander.getDelimiterStatementStart());
        properties.setProperty("DELIMITER_STATEMENT_END", BeetlConfigExpander.getDelimiterStatementEnd());
        properties.setProperty("HTML_TAG_FLAG", BeetlConfigExpander.getHtmlTagFlag());
        properties.setProperty("RESOURCE.tagRoot", BeetlConfigExpander.getResourceTagRoot());
        properties.setProperty("RESOURCE.tagSuffix", BeetlConfigExpander.getResourceTagSuffix());
        properties.setProperty("RESOURCE.autoCheck", resourceAutoCheck);
        return properties;
    }
}
