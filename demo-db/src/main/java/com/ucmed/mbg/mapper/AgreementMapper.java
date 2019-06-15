package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.Agreement;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AgreementMapper {
    @Delete({
        "delete from agreement",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into agreement (id, ClinicID, ",
        "HospizationID, Name, ",
        "InformedConsentID, DeptName, ",
        "WardAreaNm, SickRoomID, ",
        "SickbedID, Sex, ",
        "Age, AgreementType, ",
        "AgreementContent, ImageData, ",
        "PatienOrAgentOpinion, PatientSignature, ",
        "LegalAgent, RelationShipWithLegalAgent, ",
        "PatienOrAgentSignDateTime, CureDoctorSign, ",
        "OperatorSign, DoctorSignDateTime)",
        "values (#{id,jdbcType=INTEGER}, #{clinicid,jdbcType=VARCHAR}, ",
        "#{hospizationid,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{informedconsentid,jdbcType=VARCHAR}, #{deptname,jdbcType=VARCHAR}, ",
        "#{wardareanm,jdbcType=VARCHAR}, #{sickroomid,jdbcType=VARCHAR}, ",
        "#{sickbedid,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=VARCHAR}, #{agreementtype,jdbcType=VARCHAR}, ",
        "#{agreementcontent,jdbcType=VARCHAR}, #{imagedata,jdbcType=VARCHAR}, ",
        "#{patienoragentopinion,jdbcType=VARCHAR}, #{patientsignature,jdbcType=VARCHAR}, ",
        "#{legalagent,jdbcType=VARCHAR}, #{relationshipwithlegalagent,jdbcType=VARCHAR}, ",
        "#{patienoragentsigndatetime,jdbcType=TIMESTAMP}, #{curedoctorsign,jdbcType=VARCHAR}, ",
        "#{operatorsign,jdbcType=VARCHAR}, #{doctorsigndatetime,jdbcType=TIMESTAMP})"
    })
    int insert(Agreement record);

    @InsertProvider(type=AgreementSqlProvider.class, method="insertSelective")
    int insertSelective(Agreement record);

    @Select({
        "select",
        "id, ClinicID, HospizationID, Name, InformedConsentID, DeptName, WardAreaNm, ",
        "SickRoomID, SickbedID, Sex, Age, AgreementType, AgreementContent, ImageData, ",
        "PatienOrAgentOpinion, PatientSignature, LegalAgent, RelationShipWithLegalAgent, ",
        "PatienOrAgentSignDateTime, CureDoctorSign, OperatorSign, DoctorSignDateTime",
        "from agreement",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ClinicID", property="clinicid", jdbcType=JdbcType.VARCHAR),
        @Result(column="HospizationID", property="hospizationid", jdbcType=JdbcType.VARCHAR),
        @Result(column="Name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="InformedConsentID", property="informedconsentid", jdbcType=JdbcType.VARCHAR),
        @Result(column="DeptName", property="deptname", jdbcType=JdbcType.VARCHAR),
        @Result(column="WardAreaNm", property="wardareanm", jdbcType=JdbcType.VARCHAR),
        @Result(column="SickRoomID", property="sickroomid", jdbcType=JdbcType.VARCHAR),
        @Result(column="SickbedID", property="sickbedid", jdbcType=JdbcType.VARCHAR),
        @Result(column="Sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="Age", property="age", jdbcType=JdbcType.VARCHAR),
        @Result(column="AgreementType", property="agreementtype", jdbcType=JdbcType.VARCHAR),
        @Result(column="AgreementContent", property="agreementcontent", jdbcType=JdbcType.VARCHAR),
        @Result(column="ImageData", property="imagedata", jdbcType=JdbcType.VARCHAR),
        @Result(column="PatienOrAgentOpinion", property="patienoragentopinion", jdbcType=JdbcType.VARCHAR),
        @Result(column="PatientSignature", property="patientsignature", jdbcType=JdbcType.VARCHAR),
        @Result(column="LegalAgent", property="legalagent", jdbcType=JdbcType.VARCHAR),
        @Result(column="RelationShipWithLegalAgent", property="relationshipwithlegalagent", jdbcType=JdbcType.VARCHAR),
        @Result(column="PatienOrAgentSignDateTime", property="patienoragentsigndatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CureDoctorSign", property="curedoctorsign", jdbcType=JdbcType.VARCHAR),
        @Result(column="OperatorSign", property="operatorsign", jdbcType=JdbcType.VARCHAR),
        @Result(column="DoctorSignDateTime", property="doctorsigndatetime", jdbcType=JdbcType.TIMESTAMP)
    })
    Agreement selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AgreementSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Agreement record);

    @Update({
        "update agreement",
        "set ClinicID = #{clinicid,jdbcType=VARCHAR},",
          "HospizationID = #{hospizationid,jdbcType=VARCHAR},",
          "Name = #{name,jdbcType=VARCHAR},",
          "InformedConsentID = #{informedconsentid,jdbcType=VARCHAR},",
          "DeptName = #{deptname,jdbcType=VARCHAR},",
          "WardAreaNm = #{wardareanm,jdbcType=VARCHAR},",
          "SickRoomID = #{sickroomid,jdbcType=VARCHAR},",
          "SickbedID = #{sickbedid,jdbcType=VARCHAR},",
          "Sex = #{sex,jdbcType=VARCHAR},",
          "Age = #{age,jdbcType=VARCHAR},",
          "AgreementType = #{agreementtype,jdbcType=VARCHAR},",
          "AgreementContent = #{agreementcontent,jdbcType=VARCHAR},",
          "ImageData = #{imagedata,jdbcType=VARCHAR},",
          "PatienOrAgentOpinion = #{patienoragentopinion,jdbcType=VARCHAR},",
          "PatientSignature = #{patientsignature,jdbcType=VARCHAR},",
          "LegalAgent = #{legalagent,jdbcType=VARCHAR},",
          "RelationShipWithLegalAgent = #{relationshipwithlegalagent,jdbcType=VARCHAR},",
          "PatienOrAgentSignDateTime = #{patienoragentsigndatetime,jdbcType=TIMESTAMP},",
          "CureDoctorSign = #{curedoctorsign,jdbcType=VARCHAR},",
          "OperatorSign = #{operatorsign,jdbcType=VARCHAR},",
          "DoctorSignDateTime = #{doctorsigndatetime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Agreement record);
}