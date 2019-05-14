package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.HosListJianggan;

public interface HosListJiangganMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HosListJianggan record);

    int insertSelective(HosListJianggan record);

    HosListJianggan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HosListJianggan record);

    int updateByPrimaryKey(HosListJianggan record);
}