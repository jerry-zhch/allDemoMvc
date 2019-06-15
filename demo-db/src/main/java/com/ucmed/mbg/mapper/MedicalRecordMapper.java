package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.MedicalRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface MedicalRecordMapper {
    @Delete({
        "delete from medicalrecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into medicalrecord (id, HospizationID, ",
        "Name, Sex, Age, ",
        "DeptName, SickbedID, ",
        "RecorderDateTime, AdmissionDateTime, ",
        "RecordType, HospizationDuration, ",
        "DoctorSign, ProfessionalTechnicalPostCode, ",
        "SignDateTime)",
        "values (#{id,jdbcType=INTEGER}, #{hospizationid,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, #{age,jdbcType=VARCHAR}, ",
        "#{deptname,jdbcType=VARCHAR}, #{sickbedid,jdbcType=VARCHAR}, ",
        "#{recorderdatetime,jdbcType=TIMESTAMP}, #{admissiondatetime,jdbcType=TIMESTAMP}, ",
        "#{recordtype,jdbcType=VARCHAR}, #{hospizationduration,jdbcType=VARCHAR}, ",
        "#{doctorsign,jdbcType=VARCHAR}, #{professionaltechnicalpostcode,jdbcType=VARCHAR}, ",
        "#{signdatetime,jdbcType=TIMESTAMP})"
    })
    int insert(MedicalRecord record);

    @InsertProvider(type=MedicalRecordSqlProvider.class, method="insertSelective")
    int insertSelective(MedicalRecord record);

    @Select({
        "select",
        "id, HospizationID, Name, Sex, Age, DeptName, SickbedID, RecorderDateTime, AdmissionDateTime, ",
        "RecordType, HospizationDuration, DoctorSign, ProfessionalTechnicalPostCode, ",
        "SignDateTime",
        "from medicalrecord",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="HospizationID", property="hospizationid", jdbcType=JdbcType.VARCHAR),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="Sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="Age", property="age", jdbcType=JdbcType.VARCHAR),
        @Result(column="DeptName", property="deptname", jdbcType=JdbcType.VARCHAR),
        @Result(column="SickbedID", property="sickbedid", jdbcType=JdbcType.VARCHAR),
        @Result(column="RecorderDateTime", property="recorderdatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="AdmissionDateTime", property="admissiondatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RecordType", property="recordtype", jdbcType=JdbcType.VARCHAR),
        @Result(column="HospizationDuration", property="hospizationduration", jdbcType=JdbcType.VARCHAR),
        @Result(column="DoctorSign", property="doctorsign", jdbcType=JdbcType.VARCHAR),
        @Result(column="ProfessionalTechnicalPostCode", property="professionaltechnicalpostcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="SignDateTime", property="signdatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    MedicalRecord selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MedicalRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MedicalRecord record);

    @Update({
        "update medicalrecord",
        "set HospizationID = #{hospizationid,jdbcType=VARCHAR},",
          "Name = #{name,jdbcType=VARCHAR},",
          "Sex = #{sex,jdbcType=VARCHAR},",
          "Age = #{age,jdbcType=VARCHAR},",
          "DeptName = #{deptname,jdbcType=VARCHAR},",
          "SickbedID = #{sickbedid,jdbcType=VARCHAR},",
          "RecorderDateTime = #{recorderdatetime,jdbcType=TIMESTAMP},",
          "AdmissionDateTime = #{admissiondatetime,jdbcType=TIMESTAMP},",
          "RecordType = #{recordtype,jdbcType=VARCHAR},",
          "HospizationDuration = #{hospizationduration,jdbcType=VARCHAR},",
          "DoctorSign = #{doctorsign,jdbcType=VARCHAR},",
          "ProfessionalTechnicalPostCode = #{professionaltechnicalpostcode,jdbcType=VARCHAR},",
          "SignDateTime = #{signdatetime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MedicalRecord record);
}