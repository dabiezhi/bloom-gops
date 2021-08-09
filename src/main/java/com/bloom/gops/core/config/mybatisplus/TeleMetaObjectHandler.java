/*
 * Copyright (c) 2001-2020 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.config.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

public class TeleMetaObjectHandler implements MetaObjectHandler {

    private static final String FIELD_ID = "id";
    private static final String FIELD_GMT_CREATED = "gmtCreated";
    private static final String FIELD_GMT_MODIFIED = "gmtModified";

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, FIELD_GMT_CREATED, Date.class, new Date());
        this.strictInsertFill(metaObject, FIELD_GMT_MODIFIED, Date.class, new Date());
        this.strictInsertFill(metaObject, FIELD_ID, Long.class, 1L);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, FIELD_GMT_MODIFIED, Date.class, new Date());
    }
}
