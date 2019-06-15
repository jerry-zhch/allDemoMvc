package com.ucmed.mbg.mapper;

import com.ucmed.mbg.model.MedicalRecord;
import org.apache.ibatis.jdbc.SQL;

public class MedicalRecordSqlProvider {

    public String insertSelective(MedicalRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("medicalrecord");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getHospizationid() != null) {
            sql.VALUES("HospizationID", "#{hospizationid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("Name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("Sex", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            sql.VALUES("Age", "#{age,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptname() != null) {
            sql.VALUES("DeptName", "#{deptname,jdbcType=VARCHAR}");
        }
        
        if (record.getSickbedid() != null) {
            sql.VALUES("SickbedID", "#{sickbedid,jdbcType=VARCHAR}");
        }
        
        if (record.getRecorderdatetime() != null) {
            sql.VALUES("RecorderDateTime", "#{recorderdatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAdmissiondatetime() != null) {
            sql.VALUES("AdmissionDateTime", "#{admissiondatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRecordtype() != null) {
            sql.VALUES("RecordType", "#{recordtype,jdbcType=VARCHAR}");
        }
        
        if (record.getHospizationduration() != null) {
            sql.VALUES("HospizationDuration", "#{hospizationduration,jdbcType=VARCHAR}");
        }
        
        if (record.getDoctorsign() != null) {
            sql.VALUES("DoctorSign", "#{doctorsign,jdbcType=VARCHAR}");
        }
        
        if (record.getProfessionaltechnicalpostcode() != null) {
            sql.VALUES("ProfessionalTechnicalPostCode", "#{professionaltechnicalpostcode,jdbcType=VARCHAR}");
        }
        
        if (record.getSigndatetime() != null) {
            sql.VALUES("SignDateTime", "#{signdatetime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(MedicalRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("medicalrecord");
        
        if (record.getHospizationid() != null) {
            sql.SET("HospizationID = #{hospizationid,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("Name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("Sex = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            sql.SET("Age = #{age,jdbcType=VARCHAR}");
        }
        
        if (record.getDeptname() != null) {
            sql.SET("DeptName = #{deptname,jdbcType=VARCHAR}");
        }
        
        if (record.getSickbedid() != null) {
            sql.SET("SickbedID = #{sickbedid,jdbcType=VARCHAR}");
        }
        
        if (record.getRecorderdatetime() != null) {
            sql.SET("RecorderDateTime = #{recorderdatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAdmissiondatetime() != null) {
            sql.SET("AdmissionDateTime = #{admissiondatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRecordtype() != null) {
            sql.SET("RecordType = #{recordtype,jdbcType=VARCHAR}");
        }
        
        if (record.getHospizationduration() != null) {
            sql.SET("HospizationDuration = #{hospizationduration,jdbcType=VARCHAR}");
        }
        
        if (record.getDoctorsign() != null) {
            sql.SET("DoctorSign = #{doctorsign,jdbcType=VARCHAR}");
        }
        
        if (record.getProfessionaltechnicalpostcode() != null) {
            sql.SET("ProfessionalTechnicalPostCode = #{professionaltechnicalpostcode,jdbcType=VARCHAR}");
        }
        
        if (record.getSigndatetime() != null) {
            sql.SET("SignDateTime = #{signdatetime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}