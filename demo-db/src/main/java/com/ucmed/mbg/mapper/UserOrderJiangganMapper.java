package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.UserOrderJianggan;

public interface UserOrderJiangganMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserOrderJianggan record);

    int insertSelective(UserOrderJianggan record);

    UserOrderJianggan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserOrderJianggan record);

    int updateByPrimaryKey(UserOrderJianggan record);
}