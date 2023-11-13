package com.bob.bobpal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bob.bobpal.model.domain.Team;
import com.bob.bobpal.model.domain.User;
import com.bob.bobpal.model.dto.TeamQuery;
import com.bob.bobpal.model.request.TeamJoinRequest;
import com.bob.bobpal.model.request.TeamUpdateRequest;
import com.bob.bobpal.model.vo.TeamUserVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;


/**
 * @author SuperBob
 * @description 针对表【team(队伍)】的数据库操作Service
 * @createDate 2023-11-07 17:30:24
 */
public interface TeamService extends IService<Team> {
    /**
     * 创建队伍
     *
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     *
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin) throws InvocationTargetException, IllegalAccessException;


    /**
     * 更新队伍信息
     *
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     *
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest,User loginUser);
}
