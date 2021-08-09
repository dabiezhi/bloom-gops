/*
 * Copyright (c) 2001-2021 GuaHao.com Corporation Limited. All rights reserved.
 * This software is the confidential and proprietary information of GuaHao Company.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with GuaHao.com.
 */
package com.bloom.gops.core.beetl.expander;

import com.bloom.gops.core.beetl.contants.BeetlConstants;

public class BeetlConfigExpander {

    /**
     * 边界符开始符号
     *
     * @author fengshuonan
     * @date 2020/12/27 12:27
     */
    public static String getDelimiterStatementStart() {
        return BeetlConstants.DEFAULT_DELIMITER_STATEMENT_START;
    }

    /**
     * beetl边界符的结束符号
     *
     * @author fengshuonan
     * @date 2020/12/27 12:27
     */
    public static String getDelimiterStatementEnd() {
        return BeetlConstants.DEFAULT_DELIMITER_STATEMENT_END;
    }

    /**
     * 自定义标签文件Root目录
     *
     * @author fengshuonan
     * @date 2020/12/27 12:27
     */
    public static String getResourceTagRoot() {
        return BeetlConstants.DEFAULT_RESOURCE_TAG_ROOT;
    }

    /**
     * 自定义标签文件后缀
     *
     * @author fengshuonan
     * @date 2020/12/27 12:27
     */
    public static String getResourceTagSuffix() {
        return BeetlConstants.DEFAULT_RESOURCE_TAG_SUFFIX;
    }

    /**
     * 自定义支持HTML标签
     *
     * @author liuhanqing
     * @date 2021/1/16 21:06
     */
    public static String getHtmlTagFlag() {
        return BeetlConstants.DEFAULT_HTML_TAG_FLAG;
    }
}
