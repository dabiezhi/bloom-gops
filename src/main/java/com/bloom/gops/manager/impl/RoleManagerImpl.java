package com.bloom.gops.manager.impl;

import com.bloom.gops.manager.RoleManager;
import com.bloom.gops.manager.UserManager;
import com.bloom.gops.mapper.RoleMapper;
import com.bloom.gops.mapper.dataobject.Role;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author taosy
 * Created by on 2022-01-20 下午5:43
 */
@Component
public class RoleManagerImpl implements RoleManager {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public void add(Role role) {
        roleMapper.insert(role);
        Integer i = null;
        i++;
    }
}