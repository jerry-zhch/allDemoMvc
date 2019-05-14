package com.ucmed.mbg2.mapper;

import com.ucmed.mbg2.model.MsgFlowJianggan;
import org.apache.ibatis.jdbc.SQL;

public class MsgFlowJiangganSqlProvider {

    public String insertSelective(MsgFlowJianggan record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("msg_flow_jianggan");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getSendMobile() != null) {
            sql.VALUES("send_mobile", "#{sendMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverMobile() != null) {
            sql.VALUES("receiver_mobile", "#{receiverMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getSendTime() != null) {
            sql.VALUES("send_time", "#{sendTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getMsgStatus() != null) {
            sql.VALUES("msg_status", "#{msgStatus,jdbcType=CHAR}");
        }
        
        if (record.getErrorMsg() != null) {
            sql.VALUES("error_msg", "#{errorMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=CHAR}");
        }
        
        if (record.getTemp() != null) {
            sql.VALUES("temp", "#{temp,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MsgFlowJianggan record) {
        SQL sql = new SQL();
        sql.UPDATE("msg_flow_jianggan");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getSendMobile() != null) {
            sql.SET("send_mobile = #{sendMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiverMobile() != null) {
            sql.SET("receiver_mobile = #{receiverMobile,jdbcType=VARCHAR}");
        }
        
        if (record.getSendTime() != null) {
            sql.SET("send_time = #{sendTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getMsgStatus() != null) {
            sql.SET("msg_status = #{msgStatus,jdbcType=CHAR}");
        }
        
        if (record.getErrorMsg() != null) {
            sql.SET("error_msg = #{errorMsg,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=CHAR}");
        }
        
        if (record.getTemp() != null) {
            sql.SET("temp = #{temp,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}