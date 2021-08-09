/*
 * Copyright (c) 2001-2021 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.beetl.expander;

import com.bloom.gops.core.beetl.contants.SystemConstants;

public class SystemConfigExpander {
    public SystemConfigExpander() {
    }

    public static String getReleaseVersion() {
        return SystemConstants.DEFAULT_SYSTEM_VERSION;
    }

    public static Boolean getTenantOpen() {
        return SystemConstants.DEFAULT_TENANT_OPEN;
    }

    public static Boolean getCaptchaOpen() {
        return SystemConstants.DEFAULT_CAPTCHA_OPEN;
    }

    public static String getSystemName() {
        return SystemConstants.DEFAULT_SYSTEM_NAME;
    }

    public static String getDefaultPassWord() {
        return SystemConstants.SYS_DEFAULT_PASSWORD;
    }

}
