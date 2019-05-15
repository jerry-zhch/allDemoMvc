package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.UserOrderJianggan;
import org.apache.ibatis.jdbc.SQL;

public class UserOrderJiangganSqlProvider {

    public String insertSelective(UserOrderJianggan record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_order_jianggan");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCard() != null) {
            sql.VALUES("id_card", "#{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getScheduleNum() != null) {
            sql.VALUES("schedule_num", "#{scheduleNum,jdbcType=VARCHAR}");
        }
        
        if (record.getClinicDate() != null) {
            sql.VALUES("clinic_date", "#{clinicDate,jdbcType=VARCHAR}");
        }
        
        if (record.getYysjdNum() != null) {
            sql.VALUES("yysjd_num", "#{yysjdNum,jdbcType=VARCHAR}");
        }
        
        if (record.getYysjd() != null) {
            sql.VALUES("yysjd", "#{yysjd,jdbcType=VARCHAR}");
        }
        
        if (record.getYylsh() != null) {
            sql.VALUES("yylsh", "#{yylsh,jdbcType=VARCHAR}");
        }
        
        if (record.getHosId() != null) {
            sql.VALUES("hos_id", "#{hosId,jdbcType=VARCHAR}");
        }
        
        if (record.getHosName() != null) {
            sql.VALUES("hos_name", "#{hosName,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptId() != null) {
            sql.VALUES("dept_id", "#{deptId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptName() != null) {
            sql.VALUES("dept_name", "#{deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getDocId() != null) {
            sql.VALUES("doc_id", "#{docId,jdbcType=VARCHAR}");
        }
        
        if (record.getDocName() != null) {
            sql.VALUES("doc_name", "#{docName,jdbcType=VARCHAR}");
        }
        
        if (record.getRegFee() != null) {
            sql.VALUES("reg_fee", "#{regFee,jdbcType=VARCHAR}");
        }
        
        if (record.getClinicFee() != null) {
            sql.VALUES("clinic_fee", "#{clinicFee,jdbcType=VARCHAR}");
        }
        
        if (record.getOnlineFee() != null) {
            sql.VALUES("online_fee", "#{onlineFee,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=VARCHAR}");
        }
        
        if (record.getIsCancel() != null) {
            sql.VALUES("is_cancel", "#{isCancel,jdbcType=VARCHAR}");
        }
        
        if (record.getTemp1() != null) {
            sql.VALUES("temp1", "#{temp1,jdbcType=VARCHAR}");
        }
        
        if (record.getTemp2() != null) {
            sql.VALUES("temp2", "#{temp2,jdbcType=VARCHAR}");
        }
        
        if (record.getTemp3() != null) {
            sql.VALUES("temp3", "#{temp3,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UserOrderJianggan record) {
        SQL sql = new SQL();
        sql.UPDATE("user_order_jianggan");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIdCard() != null) {
            sql.SET("id_card = #{idCard,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getScheduleNum() != null) {
            sql.SET("schedule_num = #{scheduleNum,jdbcType=VARCHAR}");
        }
        
        if (record.getClinicDate() != null) {
            sql.SET("clinic_date = #{clinicDate,jdbcType=VARCHAR}");
        }
        
        if (record.getYysjdNum() != null) {
            sql.SET("yysjd_num = #{yysjdNum,jdbcType=VARCHAR}");
        }
        
        if (record.getYysjd() != null) {
            sql.SET("yysjd = #{yysjd,jdbcType=VARCHAR}");
        }
        
        if (record.getYylsh() != null) {
            sql.SET("yylsh = #{yylsh,jdbcType=VARCHAR}");
        }
        
        if (record.getHosId() != null) {
            sql.SET("hos_id = #{hosId,jdbcType=VARCHAR}");
        }
        
        if (record.getHosName() != null) {
            sql.SET("hos_name = #{hosName,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptId() != null) {
            sql.SET("dept_id = #{deptId,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptName() != null) {
            sql.SET("dept_name = #{deptName,jdbcType=VARCHAR}");
        }
        
        if (record.getDocId() != null) {
            sql.SET("doc_id = #{docId,jdbcType=VARCHAR}");
        }
        
        if (record.getDocName() != null) {
            sql.SET("doc_name = #{docName,jdbcType=VARCHAR}");
        }
        
        if (record.getRegFee() != null) {
            sql.SET("reg_fee = #{regFee,jdbcType=VARCHAR}");
        }
        
        if (record.getClinicFee() != null) {
            sql.SET("clinic_fee = #{clinicFee,jdbcType=VARCHAR}");
        }
        
        if (record.getOnlineFee() != null) {
            sql.SET("online_fee = #{onlineFee,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=VARCHAR}");
        }
        
        if (record.getIsCancel() != null) {
            sql.SET("is_cancel = #{isCancel,jdbcType=VARCHAR}");
        }
        
        if (record.getTemp1() != null) {
            sql.SET("temp1 = #{temp1,jdbcType=VARCHAR}");
        }
        
        if (record.getTemp2() != null) {
            sql.SET("temp2 = #{temp2,jdbcType=VARCHAR}");
        }
        
        if (record.getTemp3() != null) {
            sql.SET("temp3 = #{temp3,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}