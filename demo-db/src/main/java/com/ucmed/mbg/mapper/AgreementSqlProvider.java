package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.Agreement;
import org.apache.ibatis.jdbc.SQL;

public class AgreementSqlProvider {

    public String insertSelective(Agreement record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("agreement");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getClinicid() != null) {
            sql.VALUES("ClinicID", "#{clinicid,jdbcType=VARCHAR}");
        }
        
        if (record.getHospizationid() != null) {
            sql.VALUES("HospizationID", "#{hospizationid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("Name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getInformedconsentid() != null) {
            sql.VALUES("InformedConsentID", "#{informedconsentid,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptname() != null) {
            sql.VALUES("DeptName", "#{deptname,jdbcType=VARCHAR}");
        }
        
        if (record.getWardareanm() != null) {
            sql.VALUES("WardAreaNm", "#{wardareanm,jdbcType=VARCHAR}");
        }
        
        if (record.getSickroomid() != null) {
            sql.VALUES("SickRoomID", "#{sickroomid,jdbcType=VARCHAR}");
        }
        
        if (record.getSickbedid() != null) {
            sql.VALUES("SickbedID", "#{sickbedid,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("Sex", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            sql.VALUES("Age", "#{age,jdbcType=VARCHAR}");
        }
        
        if (record.getAgreementtype() != null) {
            sql.VALUES("AgreementType", "#{agreementtype,jdbcType=VARCHAR}");
        }
        
        if (record.getAgreementcontent() != null) {
            sql.VALUES("AgreementContent", "#{agreementcontent,jdbcType=VARCHAR}");
        }
        
        if (record.getImagedata() != null) {
            sql.VALUES("ImageData", "#{imagedata,jdbcType=VARCHAR}");
        }
        
        if (record.getPatienoragentopinion() != null) {
            sql.VALUES("PatienOrAgentOpinion", "#{patienoragentopinion,jdbcType=VARCHAR}");
        }
        
        if (record.getPatientsignature() != null) {
            sql.VALUES("PatientSignature", "#{patientsignature,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalagent() != null) {
            sql.VALUES("LegalAgent", "#{legalagent,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationshipwithlegalagent() != null) {
            sql.VALUES("RelationShipWithLegalAgent", "#{relationshipwithlegalagent,jdbcType=VARCHAR}");
        }
        
        if (record.getPatienoragentsigndatetime() != null) {
            sql.VALUES("PatienOrAgentSignDateTime", "#{patienoragentsigndatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCuredoctorsign() != null) {
            sql.VALUES("CureDoctorSign", "#{curedoctorsign,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorsign() != null) {
            sql.VALUES("OperatorSign", "#{operatorsign,jdbcType=VARCHAR}");
        }
        
        if (record.getDoctorsigndatetime() != null) {
            sql.VALUES("DoctorSignDateTime", "#{doctorsigndatetime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Agreement record) {
        SQL sql = new SQL();
        sql.UPDATE("agreement");
        
        if (record.getClinicid() != null) {
            sql.SET("ClinicID = #{clinicid,jdbcType=VARCHAR}");
        }
        
        if (record.getHospizationid() != null) {
            sql.SET("HospizationID = #{hospizationid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("Name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getInformedconsentid() != null) {
            sql.SET("InformedConsentID = #{informedconsentid,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptname() != null) {
            sql.SET("DeptName = #{deptname,jdbcType=VARCHAR}");
        }
        
        if (record.getWardareanm() != null) {
            sql.SET("WardAreaNm = #{wardareanm,jdbcType=VARCHAR}");
        }
        
        if (record.getSickroomid() != null) {
            sql.SET("SickRoomID = #{sickroomid,jdbcType=VARCHAR}");
        }
        
        if (record.getSickbedid() != null) {
            sql.SET("SickbedID = #{sickbedid,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("Sex = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            sql.SET("Age = #{age,jdbcType=VARCHAR}");
        }
        
        if (record.getAgreementtype() != null) {
            sql.SET("AgreementType = #{agreementtype,jdbcType=VARCHAR}");
        }
        
        if (record.getAgreementcontent() != null) {
            sql.SET("AgreementContent = #{agreementcontent,jdbcType=VARCHAR}");
        }
        
        if (record.getImagedata() != null) {
            sql.SET("ImageData = #{imagedata,jdbcType=VARCHAR}");
        }
        
        if (record.getPatienoragentopinion() != null) {
            sql.SET("PatienOrAgentOpinion = #{patienoragentopinion,jdbcType=VARCHAR}");
        }
        
        if (record.getPatientsignature() != null) {
            sql.SET("PatientSignature = #{patientsignature,jdbcType=VARCHAR}");
        }
        
        if (record.getLegalagent() != null) {
            sql.SET("LegalAgent = #{legalagent,jdbcType=VARCHAR}");
        }
        
        if (record.getRelationshipwithlegalagent() != null) {
            sql.SET("RelationShipWithLegalAgent = #{relationshipwithlegalagent,jdbcType=VARCHAR}");
        }
        
        if (record.getPatienoragentsigndatetime() != null) {
            sql.SET("PatienOrAgentSignDateTime = #{patienoragentsigndatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCuredoctorsign() != null) {
            sql.SET("CureDoctorSign = #{curedoctorsign,jdbcType=VARCHAR}");
        }
        
        if (record.getOperatorsign() != null) {
            sql.SET("OperatorSign = #{operatorsign,jdbcType=VARCHAR}");
        }
        
        if (record.getDoctorsigndatetime() != null) {
            sql.SET("DoctorSignDateTime = #{doctorsigndatetime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}