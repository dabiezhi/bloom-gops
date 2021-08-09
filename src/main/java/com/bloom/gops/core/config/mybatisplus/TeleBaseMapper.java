/*
 * Copyright (c) 2001-2020 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.config.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface TeleBaseMapper<T> extends BaseMapper<T> {

    int deleteByIdWithFill(T entity);

}
