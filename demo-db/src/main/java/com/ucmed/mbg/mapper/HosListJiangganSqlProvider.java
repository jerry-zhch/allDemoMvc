package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.HosListJianggan;
import org.apache.ibatis.jdbc.SQL;

public class HosListJiangganSqlProvider {

    public String insertSelective(HosListJianggan record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hos_list_jianggan");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getHosId() != null) {
            sql.VALUES("hos_id", "#{hosId,jdbcType=VARCHAR}");
        }
        
        if (record.getHosName() != null) {
            sql.VALUES("hos_name", "#{hosName,jdbcType=VARCHAR}");
        }
        
        if (record.getPicture() != null) {
            sql.VALUES("picture", "#{picture,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(HosListJianggan record) {
        SQL sql = new SQL();
        sql.UPDATE("hos_list_jianggan");
        
        if (record.getHosId() != null) {
            sql.SET("hos_id = #{hosId,jdbcType=VARCHAR}");
        }
        
        if (record.getHosName() != null) {
            sql.SET("hos_name = #{hosName,jdbcType=VARCHAR}");
        }
        
        if (record.getPicture() != null) {
            sql.SET("picture = #{picture,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}