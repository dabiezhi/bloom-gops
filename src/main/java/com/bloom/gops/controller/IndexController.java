/*
 * Copyright (c) 2001-2021 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.controller;


import com.bloom.gops.core.interceptor.MenuTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Resource
    private HttpServletRequest request;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("menuList", initMenuList());
        return "/index.html";
    }

    @RequestMapping(value = "/notfound")
    public String notFound() {
        return "/404.html";
    }

    private List<MenuTreeNode> initMenuList() {
        List<MenuTreeNode> menuList = new ArrayList<>();

        MenuTreeNode orgMenu = new MenuTreeNode();
        orgMenu.setMenuName("系统设置");
        orgMenu.setPath("1");
        orgMenu.setMenuId(1L);

        MenuTreeNode orgNode1 = new MenuTreeNode();
        orgNode1.setMenuName("机构管理");
        orgNode1.setPath("/view/org");
        orgNode1.setMenuId(12L);
        orgNode1.setMenuParentId(1L);

        MenuTreeNode orgNode2 = new MenuTreeNode();
        orgNode2.setMenuName("人员管理");
        orgNode2.setPath("3");
        orgNode2.setMenuId(13L);
        orgNode2.setMenuParentId(1L);
        orgMenu.setChildren(Arrays.asList(orgNode1, orgNode2));

        MenuTreeNode menu2 = new MenuTreeNode();
        menu2.setMenuName("菜单二");
        menu2.setPath("21");
        menu2.setMenuId(2L);

        MenuTreeNode orgNode22 = new MenuTreeNode();
        orgNode22.setMenuName("菜单二-子菜单1");
        orgNode22.setPath("2");
        orgNode22.setMenuId(22L);
        orgNode22.setMenuParentId(2L);

        MenuTreeNode orgNode23 = new MenuTreeNode();
        orgNode23.setMenuName("菜单二-子菜单2");
        orgNode23.setPath("3");
        orgNode23.setMenuId(23L);
        orgNode23.setMenuParentId(2L);
        menu2.setChildren(Arrays.asList(orgNode22, orgNode23));
        return Arrays.asList(orgMenu, menu2);
    }

}
