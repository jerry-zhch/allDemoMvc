package com.ucmed.mbg2.mapper;

import com.ucmed.mbg2.model.MsgFlowJianggan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MsgFlowJiangganMapper {
    @Delete({
        "delete from msg_flow_jianggan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into msg_flow_jianggan (id, user_id, ",
        "send_mobile, receiver_mobile, ",
        "send_time, content, ",
        "msg_status, error_msg, ",
        "type, temp)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{sendMobile,jdbcType=VARCHAR}, #{receiverMobile,jdbcType=VARCHAR}, ",
        "#{sendTime,jdbcType=TIMESTAMP}, #{content,jdbcType=VARCHAR}, ",
        "#{msgStatus,jdbcType=CHAR}, #{errorMsg,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=CHAR}, #{temp,jdbcType=VARCHAR})"
    })
    int insert(MsgFlowJianggan record);

    @InsertProvider(type=MsgFlowJiangganSqlProvider.class, method="insertSelective")
    int insertSelective(MsgFlowJianggan record);

    @Select({
        "select",
        "id, user_id, send_mobile, receiver_mobile, send_time, content, msg_status, error_msg, ",
        "type, temp",
        "from msg_flow_jianggan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="send_mobile", property="sendMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="receiver_mobile", property="receiverMobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="send_time", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg_status", property="msgStatus", jdbcType=JdbcType.CHAR),
        @Result(column="error_msg", property="errorMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.CHAR),
        @Result(column="temp", property="temp", jdbcType=JdbcType.VARCHAR)
    })
    MsgFlowJianggan selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MsgFlowJiangganSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MsgFlowJianggan record);

    @Update({
        "update msg_flow_jianggan",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "send_mobile = #{sendMobile,jdbcType=VARCHAR},",
          "receiver_mobile = #{receiverMobile,jdbcType=VARCHAR},",
          "send_time = #{sendTime,jdbcType=TIMESTAMP},",
          "content = #{content,jdbcType=VARCHAR},",
          "msg_status = #{msgStatus,jdbcType=CHAR},",
          "error_msg = #{errorMsg,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=CHAR},",
          "temp = #{temp,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MsgFlowJianggan record);
}