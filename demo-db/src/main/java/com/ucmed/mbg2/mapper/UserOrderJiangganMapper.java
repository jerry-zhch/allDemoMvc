package com.ucmed.mbg2.mapper;

import com.ucmed.mbg2.model.UserOrderJianggan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserOrderJiangganMapper {
    @Delete({
        "delete from user_order_jianggan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_order_jianggan (id, name, ",
        "id_card, phone, schedule_num, ",
        "clinic_date, yysjd_num, ",
        "yysjd, yylsh, hos_id, ",
        "hos_name, dept_id, ",
        "dept_name, doc_id, ",
        "doc_name, reg_fee, ",
        "clinic_fee, online_fee, ",
        "update_time, is_cancel, ",
        "temp1, temp2, temp3)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{idCard,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{scheduleNum,jdbcType=VARCHAR}, ",
        "#{clinicDate,jdbcType=VARCHAR}, #{yysjdNum,jdbcType=VARCHAR}, ",
        "#{yysjd,jdbcType=VARCHAR}, #{yylsh,jdbcType=VARCHAR}, #{hosId,jdbcType=VARCHAR}, ",
        "#{hosName,jdbcType=VARCHAR}, #{deptId,jdbcType=VARCHAR}, ",
        "#{deptName,jdbcType=VARCHAR}, #{docId,jdbcType=VARCHAR}, ",
        "#{docName,jdbcType=VARCHAR}, #{regFee,jdbcType=VARCHAR}, ",
        "#{clinicFee,jdbcType=VARCHAR}, #{onlineFee,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=VARCHAR}, #{isCancel,jdbcType=VARCHAR}, ",
        "#{temp1,jdbcType=VARCHAR}, #{temp2,jdbcType=VARCHAR}, #{temp3,jdbcType=VARCHAR})"
    })
    int insert(UserOrderJianggan record);

    @InsertProvider(type=UserOrderJiangganSqlProvider.class, method="insertSelective")
    int insertSelective(UserOrderJianggan record);

    @Select({
        "select",
        "id, name, id_card, phone, schedule_num, clinic_date, yysjd_num, yysjd, yylsh, ",
        "hos_id, hos_name, dept_id, dept_name, doc_id, doc_name, reg_fee, clinic_fee, ",
        "online_fee, update_time, is_cancel, temp1, temp2, temp3",
        "from user_order_jianggan",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card", property="idCard", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="schedule_num", property="scheduleNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="clinic_date", property="clinicDate", jdbcType=JdbcType.VARCHAR),
        @Result(column="yysjd_num", property="yysjdNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="yysjd", property="yysjd", jdbcType=JdbcType.VARCHAR),
        @Result(column="yylsh", property="yylsh", jdbcType=JdbcType.VARCHAR),
        @Result(column="hos_id", property="hosId", jdbcType=JdbcType.VARCHAR),
        @Result(column="hos_name", property="hosName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_name", property="deptName", jdbcType=JdbcType.VARCHAR),
        @Result(column="doc_id", property="docId", jdbcType=JdbcType.VARCHAR),
        @Result(column="doc_name", property="docName", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_fee", property="regFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="clinic_fee", property="clinicFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="online_fee", property="onlineFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_cancel", property="isCancel", jdbcType=JdbcType.VARCHAR),
        @Result(column="temp1", property="temp1", jdbcType=JdbcType.VARCHAR),
        @Result(column="temp2", property="temp2", jdbcType=JdbcType.VARCHAR),
        @Result(column="temp3", property="temp3", jdbcType=JdbcType.VARCHAR)
    })
    UserOrderJianggan selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserOrderJiangganSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserOrderJianggan record);

    @Update({
        "update user_order_jianggan",
        "set name = #{name,jdbcType=VARCHAR},",
          "id_card = #{idCard,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "schedule_num = #{scheduleNum,jdbcType=VARCHAR},",
          "clinic_date = #{clinicDate,jdbcType=VARCHAR},",
          "yysjd_num = #{yysjdNum,jdbcType=VARCHAR},",
          "yysjd = #{yysjd,jdbcType=VARCHAR},",
          "yylsh = #{yylsh,jdbcType=VARCHAR},",
          "hos_id = #{hosId,jdbcType=VARCHAR},",
          "hos_name = #{hosName,jdbcType=VARCHAR},",
          "dept_id = #{deptId,jdbcType=VARCHAR},",
          "dept_name = #{deptName,jdbcType=VARCHAR},",
          "doc_id = #{docId,jdbcType=VARCHAR},",
          "doc_name = #{docName,jdbcType=VARCHAR},",
          "reg_fee = #{regFee,jdbcType=VARCHAR},",
          "clinic_fee = #{clinicFee,jdbcType=VARCHAR},",
          "online_fee = #{onlineFee,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=VARCHAR},",
          "is_cancel = #{isCancel,jdbcType=VARCHAR},",
          "temp1 = #{temp1,jdbcType=VARCHAR},",
          "temp2 = #{temp2,jdbcType=VARCHAR},",
          "temp3 = #{temp3,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserOrderJianggan record);
}