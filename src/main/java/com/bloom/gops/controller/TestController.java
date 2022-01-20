package com.bloom.gops.controller;

import com.bloom.gops.manager.OrgManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author taosy
 * Created by on 2022-01-20 下午5:37
 */
@RestController
public class TestController {

    @Resource
    private OrgManager orgManager;

    @RequestMapping("/demo")
    public String demo() {
        orgManager.add();
        return "success";
    }
}