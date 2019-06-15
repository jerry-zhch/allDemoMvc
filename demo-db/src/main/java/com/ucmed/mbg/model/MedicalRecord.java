package com.ucmed.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class MedicalRecord implements Serializable {
    private Integer id;

    private String hospizationid;

    private String name;

    private String sex;

    private String age;

    private String deptname;

    private String sickbedid;

    private Date recorderdatetime;

    private Date admissiondatetime;

    private String recordtype;

    private String hospizationduration;

    private String doctorsign;

    private String professionaltechnicalpostcode;

    private Date signdatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospizationid() {
        return hospizationid;
    }

    public void setHospizationid(String hospizationid) {
        this.hospizationid = hospizationid == null ? null : hospizationid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getSickbedid() {
        return sickbedid;
    }

    public void setSickbedid(String sickbedid) {
        this.sickbedid = sickbedid == null ? null : sickbedid.trim();
    }

    public Date getRecorderdatetime() {
        return recorderdatetime;
    }

    public void setRecorderdatetime(Date recorderdatetime) {
        this.recorderdatetime = recorderdatetime;
    }

    public Date getAdmissiondatetime() {
        return admissiondatetime;
    }

    public void setAdmissiondatetime(Date admissiondatetime) {
        this.admissiondatetime = admissiondatetime;
    }

    public String getRecordtype() {
        return recordtype;
    }

    public void setRecordtype(String recordtype) {
        this.recordtype = recordtype == null ? null : recordtype.trim();
    }

    public String getHospizationduration() {
        return hospizationduration;
    }

    public void setHospizationduration(String hospizationduration) {
        this.hospizationduration = hospizationduration == null ? null : hospizationduration.trim();
    }

    public String getDoctorsign() {
        return doctorsign;
    }

    public void setDoctorsign(String doctorsign) {
        this.doctorsign = doctorsign == null ? null : doctorsign.trim();
    }

    public String getProfessionaltechnicalpostcode() {
        return professionaltechnicalpostcode;
    }

    public void setProfessionaltechnicalpostcode(String professionaltechnicalpostcode) {
        this.professionaltechnicalpostcode = professionaltechnicalpostcode == null ? null : professionaltechnicalpostcode.trim();
    }

    public Date getSigndatetime() {
        return signdatetime;
    }

    public void setSigndatetime(Date signdatetime) {
        this.signdatetime = signdatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", hospizationid=").append(hospizationid);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", deptname=").append(deptname);
        sb.append(", sickbedid=").append(sickbedid);
        sb.append(", recorderdatetime=").append(recorderdatetime);
        sb.append(", admissiondatetime=").append(admissiondatetime);
        sb.append(", recordtype=").append(recordtype);
        sb.append(", hospizationduration=").append(hospizationduration);
        sb.append(", doctorsign=").append(doctorsign);
        sb.append(", professionaltechnicalpostcode=").append(professionaltechnicalpostcode);
        sb.append(", signdatetime=").append(signdatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}