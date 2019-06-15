package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.hosList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface hosListMapper {
    @Delete({
        "delete from hos_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hos_list (id, hos_name, ",
        "nuts_url, add_date, ",
        "temp1, temp2, temp3)",
        "values (#{id,jdbcType=INTEGER}, #{hosName,jdbcType=VARCHAR}, ",
        "#{nutsUrl,jdbcType=VARCHAR}, #{addDate,jdbcType=VARCHAR}, ",
        "#{temp1,jdbcType=VARCHAR}, #{temp2,jdbcType=VARCHAR}, #{temp3,jdbcType=VARCHAR})"
    })
    int insert(hosList record);

    @InsertProvider(type=hosListSqlProvider.class, method="insertSelective")
    int insertSelective(hosList record);

    @Select({
        "select",
        "id, hos_name, nuts_url, add_date, temp1, temp2, temp3",
        "from hos_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hos_name", property="hosName", jdbcType=JdbcType.VARCHAR),
        @Result(column="nuts_url", property="nutsUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_date", property="addDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="temp1", property="temp1", jdbcType=JdbcType.VARCHAR),
        @Result(column="temp2", property="temp2", jdbcType=JdbcType.VARCHAR),
        @Result(column="temp3", property="temp3", jdbcType=JdbcType.VARCHAR)
    })
    hosList selectByPrimaryKey(Integer id);

    @UpdateProvider(type=hosListSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(hosList record);

    @Update({
        "update hos_list",
        "set hos_name = #{hosName,jdbcType=VARCHAR},",
          "nuts_url = #{nutsUrl,jdbcType=VARCHAR},",
          "add_date = #{addDate,jdbcType=VARCHAR},",
          "temp1 = #{temp1,jdbcType=VARCHAR},",
          "temp2 = #{temp2,jdbcType=VARCHAR},",
          "temp3 = #{temp3,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(hosList record);
}