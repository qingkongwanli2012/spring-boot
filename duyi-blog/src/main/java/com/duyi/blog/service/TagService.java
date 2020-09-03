package com.duyi.blog.service;

import com.duyi.blog.entity.Tag;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface TagService {

    List<Tag> getAll();

    int addTag(Tag tag);

    PageInfo<Tag> getTagByCondition(Map<String, Object> map);

    int delTag(int id);

    Tag getTag(int id);

    int updateTag(Tag tag);

}
