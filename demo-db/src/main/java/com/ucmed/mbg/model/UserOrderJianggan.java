package com.ucmed.mbg.model;

import java.io.Serializable;

public class UserOrderJianggan implements Serializable {
    private Integer id;

    private String name;

    private String idCard;

    private String phone;

    private String scheduleNum;

    private String clinicDate;

    private String yysjdNum;

    private String yysjd;

    private String yylsh;

    private String hosId;

    private String hosName;

    private String deptId;

    private String deptName;

    private String docId;

    private String docName;

    private String regFee;

    private String clinicFee;

    private String onlineFee;

    private String updateTime;

    private String isCancel;

    private String temp1;

    private String temp2;

    private String temp3;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getScheduleNum() {
        return scheduleNum;
    }

    public void setScheduleNum(String scheduleNum) {
        this.scheduleNum = scheduleNum == null ? null : scheduleNum.trim();
    }

    public String getClinicDate() {
        return clinicDate;
    }

    public void setClinicDate(String clinicDate) {
        this.clinicDate = clinicDate == null ? null : clinicDate.trim();
    }

    public String getYysjdNum() {
        return yysjdNum;
    }

    public void setYysjdNum(String yysjdNum) {
        this.yysjdNum = yysjdNum == null ? null : yysjdNum.trim();
    }

    public String getYysjd() {
        return yysjd;
    }

    public void setYysjd(String yysjd) {
        this.yysjd = yysjd == null ? null : yysjd.trim();
    }

    public String getYylsh() {
        return yylsh;
    }

    public void setYylsh(String yylsh) {
        this.yylsh = yylsh == null ? null : yylsh.trim();
    }

    public String getHosId() {
        return hosId;
    }

    public void setHosId(String hosId) {
        this.hosId = hosId == null ? null : hosId.trim();
    }

    public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName == null ? null : hosName.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getRegFee() {
        return regFee;
    }

    public void setRegFee(String regFee) {
        this.regFee = regFee == null ? null : regFee.trim();
    }

    public String getClinicFee() {
        return clinicFee;
    }

    public void setClinicFee(String clinicFee) {
        this.clinicFee = clinicFee == null ? null : clinicFee.trim();
    }

    public String getOnlineFee() {
        return onlineFee;
    }

    public void setOnlineFee(String onlineFee) {
        this.onlineFee = onlineFee == null ? null : onlineFee.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel == null ? null : isCancel.trim();
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2 == null ? null : temp2.trim();
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", idCard=").append(idCard);
        sb.append(", phone=").append(phone);
        sb.append(", scheduleNum=").append(scheduleNum);
        sb.append(", clinicDate=").append(clinicDate);
        sb.append(", yysjdNum=").append(yysjdNum);
        sb.append(", yysjd=").append(yysjd);
        sb.append(", yylsh=").append(yylsh);
        sb.append(", hosId=").append(hosId);
        sb.append(", hosName=").append(hosName);
        sb.append(", deptId=").append(deptId);
        sb.append(", deptName=").append(deptName);
        sb.append(", docId=").append(docId);
        sb.append(", docName=").append(docName);
        sb.append(", regFee=").append(regFee);
        sb.append(", clinicFee=").append(clinicFee);
        sb.append(", onlineFee=").append(onlineFee);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isCancel=").append(isCancel);
        sb.append(", temp1=").append(temp1);
        sb.append(", temp2=").append(temp2);
        sb.append(", temp3=").append(temp3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}