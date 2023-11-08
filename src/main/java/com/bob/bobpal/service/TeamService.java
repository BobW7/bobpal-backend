package com.bob.bobpal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bob.bobpal.model.domain.Team;
import com.bob.bobpal.model.domain.User;


/**
* @author SuperBob
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-11-07 17:30:24
*/
public interface TeamService extends IService<Team> {
    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);
}
