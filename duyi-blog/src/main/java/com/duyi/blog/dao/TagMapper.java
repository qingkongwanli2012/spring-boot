package com.duyi.blog.dao;

import com.duyi.blog.entity.Tag;

import java.util.List;
import java.util.Map;

public interface TagMapper {

    int insertTag(Tag tag);

    List<Tag> findTagByCondition(Map<String, Object> map);

    int updateTag(Tag tag);

    List<Tag> findTagAll();

    List<Tag> findTagByIds(List ids);

}
