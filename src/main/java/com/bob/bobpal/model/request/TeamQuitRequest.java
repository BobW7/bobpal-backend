package com.bob.bobpal.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍请求体
 *
 * @author bob
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 8364241716373120793L;

    /**
     * id
     */
    private Long teamId;


}
