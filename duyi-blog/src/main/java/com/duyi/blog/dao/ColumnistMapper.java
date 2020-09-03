package com.duyi.blog.dao;

import com.duyi.blog.entity.Columnist;

import java.util.List;
import java.util.Map;

public interface ColumnistMapper {

    List<Columnist> findColumnistAll();

    List<Columnist> findColumnistByCondition(Map<String, Object> map);

    int insertColumnist(Columnist columnist);

    int updateColumnist(Columnist columnist);

    List<Columnist> findColumnistByIds(List ids);

    List<Columnist> findColumnistByTop();
}
