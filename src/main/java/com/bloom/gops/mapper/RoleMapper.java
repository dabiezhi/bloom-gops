package com.bloom.gops.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bloom.gops.mapper.dataobject.Role;
import com.bloom.gops.mapper.dataobject.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author taosy
 * Created by on 2022-01-20 下午5:39
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}