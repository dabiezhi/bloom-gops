package com.bloom.gops.core.beetl.enums;

import lombok.Getter;

@Getter
public enum SelectTagHeadTypeEnum {

    /**
     * 全部
     */
    ALL("1", "全部"),

    /**
     * 请选择
     */
    SELECT("2", "请选择");

    private final String code;

    private final String name;

    SelectTagHeadTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
