package com.duyi.blog.dao;

import com.duyi.blog.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {



    int insertComment(Comment comment);

    List<Comment> findCommentByCondition(Map<String, Object> map);

    int updateComment(Comment comment);

    List<Comment> findCommentAll();

    List<Comment> findCommentByIds(List ids);
}
