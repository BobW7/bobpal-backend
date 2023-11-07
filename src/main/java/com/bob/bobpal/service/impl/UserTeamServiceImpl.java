package com.bob.bobpal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bob.bobpal.mapper.UserTeamMapper;
import com.bob.bobpal.model.domain.UserTeam;
import com.bob.bobpal.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author SuperBob
* @description 针对表【user_team(用户-队伍关系)】的数据库操作Service实现
* @createDate 2023-11-07 17:33:01
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




