/*
 * Copyright (c) 2001-2021 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.interceptor;

import java.util.List;

import lombok.Data;

@Data
public class MenuTreeNode {

    private Long menuId;
    private Long menuParentId;
    private String menuName;
    private String path;
    private String icon;
    private List<MenuTreeNode> children;
}
