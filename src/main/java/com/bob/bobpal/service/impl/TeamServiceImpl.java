package com.bob.bobpal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bob.bobpal.mapper.TeamMapper;
import com.bob.bobpal.model.domain.Team;
import com.bob.bobpal.service.TeamService;

import org.springframework.stereotype.Service;

/**
* @author SuperBob
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2023-11-07 17:30:24
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService {

}




