package com.bob.bobpal.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * 队伍查询封装类
 */
@Data
public class TeamQuery {
    /**
     * id
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 0-公开，1-私有，2-加密
     */
    private Integer status;


}
