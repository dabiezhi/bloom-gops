package com.bloom.gops.manager.impl;

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
public class UserManagerImpl implements UserManager {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleManager roleManager;


    @Override
    @Transactional
    public void add() {
        User user = new User();
        user.setName("猫");
        userMapper.insert(user);
    }

    @Transactional
    public void role() {
        Role role = new Role();
        role.setName("超管");
        roleManager.add(role);
        Integer i = null;
        i++;
    }
}