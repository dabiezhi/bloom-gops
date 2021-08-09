package com.bloom.gops.core.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

    private JsonUtils() {

    }

    public static String toJson(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            log.error("json序列化转换失败", e);
            return null;
        }
    }

    public static String toJson(Object obj, SerializerFeature... features) {
        try {
            return JSON.toJSONString(obj, features);
        } catch (Exception e) {
            log.error("json序列化转换失败", e);
            return null;
        }
    }

    public static <T> T readValue(String content, Class<T> type) {
        try {
            return JSONObject.parseObject(content, type);
        } catch (Exception e) {
            log.error("json反序列化转换失败", e);
            return null;
        }
    }

    public static <T> List<T> getListFromJo(String jsonString, Class<T> clazz) {
        return JSONArray.parseArray(jsonString, clazz);
    }

    public static Map<String, Object> getMap(String json) {
        try {
            return JSONObject.parseObject(json);
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T readValue(String content, Type... types) {
        return JSONObject.parseObject(content, buildType(types));
    }

    private static Type buildType(Type... types) {
        ParameterizedTypeImpl beforeType = null;
        if (types != null && types.length > 0) {
            for (int i = types.length - 1; i > 0; i--) {
                beforeType = new ParameterizedTypeImpl(new Type[] { beforeType == null ? types[i] : beforeType }, null,
                    types[i - 1]);
            }
        }
        return beforeType;
    }
}
