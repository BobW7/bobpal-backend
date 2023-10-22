package com.bob.bobpal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.bob.bobpal.mapper.TagMapper;
import com.bob.bobpal.model.domain.Tag;
import com.bob.bobpal.service.TagService;
import org.springframework.stereotype.Service;

/**
* @author SuperBob
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2023-10-22 22:55:29
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService {

}




