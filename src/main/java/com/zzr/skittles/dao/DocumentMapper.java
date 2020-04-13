package com.zzr.skittles.dao;

import com.zzr.skittles.domain.Document;

import java.util.List;

public interface DocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer id);

    List<Document> selectAll();

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}