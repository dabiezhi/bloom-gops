/*
 * Copyright (c) 2001-2019 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfig extends FastJsonConfig {

    public JsonConfig() {

        super();

        setSerializerFeatures(SerializerFeature.BrowserSecure,
            // 消除对同一对象重复引用的优化
            SerializerFeature.DisableCircularReferenceDetect,
            // 将中文都会序列化为\Uxxxx 格式
            // 超过 −9007199254740992 到 9007199254740992 区间使用字符串，如："9007199254740993"
            SerializerFeature.BrowserCompatible,
            // 不隐藏为空的字段
            SerializerFeature.IgnoreNonFieldGetter,
            // map为Null，置为{}
            SerializerFeature.WriteMapNullValue,
            // List为Null，置为[]
            SerializerFeature.WriteNullListAsEmpty,
            // String为Null，置为""
            SerializerFeature.WriteNullStringAsEmpty);
        //1. 增加自定义注解Filter，实现影藏为空字段的定制化
        //2. 增加自定义注解Filter，实现字段脱敏的定制化
        //        setSerializeFilters(new IgnoreNullPropertyFilter(), new SensitiveValueFilter());
    }

}
