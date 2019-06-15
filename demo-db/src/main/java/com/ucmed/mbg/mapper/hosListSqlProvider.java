package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.hosList;
import org.apache.ibatis.jdbc.SQL;

public class hosListSqlProvider {

    public String insertSelective(hosList record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hos_list");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getHosName() != null) {
            sql.VALUES("hos_name", "#{hosName,jdbcType=VARCHAR}");
        }
        
        if (record.getNutsUrl() != null) {
            sql.VALUES("nuts_url", "#{nutsUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getAddDate() != null) {
            sql.VALUES("add_date", "#{addDate,jdbcType=VARCHAR}");
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

    public String updateByPrimaryKeySelective(hosList record) {
        SQL sql = new SQL();
        sql.UPDATE("hos_list");
        
        if (record.getHosName() != null) {
            sql.SET("hos_name = #{hosName,jdbcType=VARCHAR}");
        }
        
        if (record.getNutsUrl() != null) {
            sql.SET("nuts_url = #{nutsUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getAddDate() != null) {
            sql.SET("add_date = #{addDate,jdbcType=VARCHAR}");
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