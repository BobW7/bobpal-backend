package com.bob.bobpal.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用分页请求参数
 */
@Data
public class PageRequest implements Serializable {

    private static final long serialVersionID = -5860707094194210842L;

    /**
     * 页面大小
     */
    private int pageSize = 10;
    /**
     * 当前是第几页
     */
    private int pageNum = 1;
}
