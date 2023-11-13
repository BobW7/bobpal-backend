package com.bob.bobpal.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author bob
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = 8364241716373120793L;

    /**
     * id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;


}
