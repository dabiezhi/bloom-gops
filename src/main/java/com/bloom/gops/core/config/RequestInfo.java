/*
 * Copyright (c) 2001-2020 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.config;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestInfo {

    private String clientIp;
    private String methodName;
    private long executeTime;
    private List<Object> params;
    private Object result;
    private int flag;
    private String errorName;
    private Object executeFlow;

    /**
     * 请求头信息
     */
    private Map<String, String> headMap;
}

