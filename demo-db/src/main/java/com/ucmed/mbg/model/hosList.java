package com.ucmed.mbg.model;

import java.io.Serializable;

public class hosList implements Serializable {
    private Integer id;

    private String hosName;

    private String nutsUrl;

    private String addDate;

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

    public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName == null ? null : hosName.trim();
    }

    public String getNutsUrl() {
        return nutsUrl;
    }

    public void setNutsUrl(String nutsUrl) {
        this.nutsUrl = nutsUrl == null ? null : nutsUrl.trim();
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate == null ? null : addDate.trim();
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
        sb.append(", hosName=").append(hosName);
        sb.append(", nutsUrl=").append(nutsUrl);
        sb.append(", addDate=").append(addDate);
        sb.append(", temp1=").append(temp1);
        sb.append(", temp2=").append(temp2);
        sb.append(", temp3=").append(temp3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}