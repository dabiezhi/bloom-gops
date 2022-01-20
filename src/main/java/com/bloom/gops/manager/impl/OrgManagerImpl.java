package com.bloom.gops.manager.impl;

import com.bloom.gops.manager.OrgManager;
import com.bloom.gops.manager.RoleManager;
import com.bloom.gops.manager.UserManager;
import com.bloom.gops.mapper.UserMapper;
import com.bloom.gops.mapper.dataobject.Role;
import com.bloom.gops.mapper.dataobject.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author taosy
 * Created by on 2022-01-20 下午5:43
 */
@Component
public class OrgManagerImpl implements OrgManager {

    @Resource
    private UserManager userManager;
    @Resource
    private RoleManager roleManager;


    @Override
    @Transactional
    public void add() {
        userManager.add();
        org();
        role();
    }

    public void org() {
        userManager.add();
    }

    public void role() {
        Role role = new Role();
        role.setName("超管");
        roleManager.add(role);
    }
}