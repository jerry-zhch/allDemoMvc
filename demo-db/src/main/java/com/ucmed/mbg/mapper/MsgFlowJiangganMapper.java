package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.MsgFlowJianggan;

public interface MsgFlowJiangganMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MsgFlowJianggan record);

    int insertSelective(MsgFlowJianggan record);

    MsgFlowJianggan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MsgFlowJianggan record);

    int updateByPrimaryKey(MsgFlowJianggan record);
}