/*
 * Copyright (c) 2001-2021 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.beetl.contants;

public interface BeetlConstants {

    /**
     * 默认边界符开始
     * <p>
     * beetl默认的是 '<%'
     */
    String DEFAULT_DELIMITER_STATEMENT_START = "@";

    /**
     * 默认beetl边界符的结束
     * <p>
     * beetl默认的是 '%>'
     */
    String DEFAULT_DELIMITER_STATEMENT_END = "null";

    /**
     * 自定义标签文件Root目录
     */
    String DEFAULT_RESOURCE_TAG_ROOT = "common/tags";

    /**
     * 自定义标签文件后缀
     */
    String DEFAULT_RESOURCE_TAG_SUFFIX = "tag";

    /**
     * 是否检测文件变化,开发用true合适，但线上要改为false
     */
    String DEFAULT_RESOURCE_AUTO_CHECK = "false";

    /**
     * 默认beetl 支持HTML标签
     * <p>
     * beetl默认的是 '#'
     */
    String DEFAULT_HTML_TAG_FLAG = "tag:";
}
