/*
 * Copyright (c) 2001-2021 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.beetl;


import com.bloom.gops.core.beetl.expander.SystemConfigExpander;

import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

import cn.hutool.core.util.ObjectUtil;

public class CustomBeetlGroupUtilConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void initOther() {

        // 对象工具类
        groupTemplate.registerFunctionPackage("objectUtil", ObjectUtil.class);

        // 获取基本信息的工具
        groupTemplate.registerFunctionPackage("constants", SystemConfigExpander.class);
    }
}
