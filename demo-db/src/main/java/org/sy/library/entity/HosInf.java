package org.sy.library.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sy
 * @since 2019-05-13
 */
@TableName("hos_inf")
public class HosInf implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * his医院id
     */
    @TableField("hos_id_his")
    private String hosIdHis;
    /**
     * 医院名称
     */
    @TableField("hos_name")
    private String hosName;
    /**
     * 医院旧id-华佗id
     */
    @TableField("hos_id")
    private String hosId;
    /**
     * 排序的id
     */
    @TableField("sort_id")
    private Integer sortId;
    /**
     * 商户id
     */
    @TableField("mer_id")
    private String merId;
    /**
     * 产品id-1
     */
    @TableField("product_id_z")
    private String productIdZ;
    /**
     * 产品id-2
     */
    @TableField("product_id_b")
    private String productIdB;
    @TableField("order_pay")
    private Integer orderPay;
    @TableField("inpt_pay")
    private Integer inptPay;
    @TableField("clinic_pay")
    private Integer clinicPay;
    /**
     * 签名密钥
     */
    private String key;
    private String temp1;
    private String temp2;
    private String temp3;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHosIdHis() {
        return hosIdHis;
    }

    public void setHosIdHis(String hosIdHis) {
        this.hosIdHis = hosIdHis;
    }

    public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName;
    }

    public String getHosId() {
        return hosId;
    }

    public void setHosId(String hosId) {
        this.hosId = hosId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getProductIdZ() {
        return productIdZ;
    }

    public void setProductIdZ(String productIdZ) {
        this.productIdZ = productIdZ;
    }

    public String getProductIdB() {
        return productIdB;
    }

    public void setProductIdB(String productIdB) {
        this.productIdB = productIdB;
    }

    public Integer getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(Integer orderPay) {
        this.orderPay = orderPay;
    }

    public Integer getInptPay() {
        return inptPay;
    }

    public void setInptPay(Integer inptPay) {
        this.inptPay = inptPay;
    }

    public Integer getClinicPay() {
        return clinicPay;
    }

    public void setClinicPay(Integer clinicPay) {
        this.clinicPay = clinicPay;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }

    @Override
    public String toString() {
        return "HosInf{" +
        ", id=" + id +
        ", hosIdHis=" + hosIdHis +
        ", hosName=" + hosName +
        ", hosId=" + hosId +
        ", sortId=" + sortId +
        ", merId=" + merId +
        ", productIdZ=" + productIdZ +
        ", productIdB=" + productIdB +
        ", orderPay=" + orderPay +
        ", inptPay=" + inptPay +
        ", clinicPay=" + clinicPay +
        ", key=" + key +
        ", temp1=" + temp1 +
        ", temp2=" + temp2 +
        ", temp3=" + temp3 +
        "}";
    }
}
