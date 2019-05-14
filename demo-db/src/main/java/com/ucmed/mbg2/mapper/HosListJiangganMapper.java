package com.ucmed.mbg2.mapper;

import com.ucmed.mbg2.model.HosListJianggan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HosListJiangganMapper {
    @Delete({
        "delete from hos_list_jianggan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hos_list_jianggan (id, hos_id, ",
        "hos_name, picture)",
        "values (#{id,jdbcType=INTEGER}, #{hosId,jdbcType=VARCHAR}, ",
        "#{hosName,jdbcType=VARCHAR}, #{picture,jdbcType=VARCHAR})"
    })
    int insert(HosListJianggan record);

    @InsertProvider(type=HosListJiangganSqlProvider.class, method="insertSelective")
    int insertSelective(HosListJianggan record);

    @Select({
        "select",
        "id, hos_id, hos_name, picture",
        "from hos_list_jianggan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hos_id", property="hosId", jdbcType=JdbcType.VARCHAR),
        @Result(column="hos_name", property="hosName", jdbcType=JdbcType.VARCHAR),
        @Result(column="picture", property="picture", jdbcType=JdbcType.VARCHAR)
    })
    HosListJianggan selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HosListJiangganSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HosListJianggan record);

    @Update({
        "update hos_list_jianggan",
        "set hos_id = #{hosId,jdbcType=VARCHAR},",
          "hos_name = #{hosName,jdbcType=VARCHAR},",
          "picture = #{picture,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HosListJianggan record);
}