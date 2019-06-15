package com.ucmed.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class Agreement implements Serializable {
    private Integer id;

    private String clinicid;

    private String hospizationid;

    private String name;

    private String informedconsentid;

    private String deptname;

    private String wardareanm;

    private String sickroomid;

    private String sickbedid;

    private String sex;

    private String age;

    private String agreementtype;

    private String agreementcontent;

    private String imagedata;

    private String patienoragentopinion;

    private String patientsignature;

    private String legalagent;

    private String relationshipwithlegalagent;

    private Date patienoragentsigndatetime;

    private String curedoctorsign;

    private String operatorsign;

    private Date doctorsigndatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClinicid() {
        return clinicid;
    }

    public void setClinicid(String clinicid) {
        this.clinicid = clinicid == null ? null : clinicid.trim();
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

    public String getInformedconsentid() {
        return informedconsentid;
    }

    public void setInformedconsentid(String informedconsentid) {
        this.informedconsentid = informedconsentid == null ? null : informedconsentid.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getWardareanm() {
        return wardareanm;
    }

    public void setWardareanm(String wardareanm) {
        this.wardareanm = wardareanm == null ? null : wardareanm.trim();
    }

    public String getSickroomid() {
        return sickroomid;
    }

    public void setSickroomid(String sickroomid) {
        this.sickroomid = sickroomid == null ? null : sickroomid.trim();
    }

    public String getSickbedid() {
        return sickbedid;
    }

    public void setSickbedid(String sickbedid) {
        this.sickbedid = sickbedid == null ? null : sickbedid.trim();
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

    public String getAgreementtype() {
        return agreementtype;
    }

    public void setAgreementtype(String agreementtype) {
        this.agreementtype = agreementtype == null ? null : agreementtype.trim();
    }

    public String getAgreementcontent() {
        return agreementcontent;
    }

    public void setAgreementcontent(String agreementcontent) {
        this.agreementcontent = agreementcontent == null ? null : agreementcontent.trim();
    }

    public String getImagedata() {
        return imagedata;
    }

    public void setImagedata(String imagedata) {
        this.imagedata = imagedata == null ? null : imagedata.trim();
    }

    public String getPatienoragentopinion() {
        return patienoragentopinion;
    }

    public void setPatienoragentopinion(String patienoragentopinion) {
        this.patienoragentopinion = patienoragentopinion == null ? null : patienoragentopinion.trim();
    }

    public String getPatientsignature() {
        return patientsignature;
    }

    public void setPatientsignature(String patientsignature) {
        this.patientsignature = patientsignature == null ? null : patientsignature.trim();
    }

    public String getLegalagent() {
        return legalagent;
    }

    public void setLegalagent(String legalagent) {
        this.legalagent = legalagent == null ? null : legalagent.trim();
    }

    public String getRelationshipwithlegalagent() {
        return relationshipwithlegalagent;
    }

    public void setRelationshipwithlegalagent(String relationshipwithlegalagent) {
        this.relationshipwithlegalagent = relationshipwithlegalagent == null ? null : relationshipwithlegalagent.trim();
    }

    public Date getPatienoragentsigndatetime() {
        return patienoragentsigndatetime;
    }

    public void setPatienoragentsigndatetime(Date patienoragentsigndatetime) {
        this.patienoragentsigndatetime = patienoragentsigndatetime;
    }

    public String getCuredoctorsign() {
        return curedoctorsign;
    }

    public void setCuredoctorsign(String curedoctorsign) {
        this.curedoctorsign = curedoctorsign == null ? null : curedoctorsign.trim();
    }

    public String getOperatorsign() {
        return operatorsign;
    }

    public void setOperatorsign(String operatorsign) {
        this.operatorsign = operatorsign == null ? null : operatorsign.trim();
    }

    public Date getDoctorsigndatetime() {
        return doctorsigndatetime;
    }

    public void setDoctorsigndatetime(Date doctorsigndatetime) {
        this.doctorsigndatetime = doctorsigndatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clinicid=").append(clinicid);
        sb.append(", hospizationid=").append(hospizationid);
        sb.append(", name=").append(name);
        sb.append(", informedconsentid=").append(informedconsentid);
        sb.append(", deptname=").append(deptname);
        sb.append(", wardareanm=").append(wardareanm);
        sb.append(", sickroomid=").append(sickroomid);
        sb.append(", sickbedid=").append(sickbedid);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", agreementtype=").append(agreementtype);
        sb.append(", agreementcontent=").append(agreementcontent);
        sb.append(", imagedata=").append(imagedata);
        sb.append(", patienoragentopinion=").append(patienoragentopinion);
        sb.append(", patientsignature=").append(patientsignature);
        sb.append(", legalagent=").append(legalagent);
        sb.append(", relationshipwithlegalagent=").append(relationshipwithlegalagent);
        sb.append(", patienoragentsigndatetime=").append(patienoragentsigndatetime);
        sb.append(", curedoctorsign=").append(curedoctorsign);
        sb.append(", operatorsign=").append(operatorsign);
        sb.append(", doctorsigndatetime=").append(doctorsigndatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}