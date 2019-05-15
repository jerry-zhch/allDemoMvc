package com.ucmed.plus.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author zhch
 * @since 2019-05-14
 */
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户年龄
     */
    private Integer age;
    /**
     * 0、禁用 1、正常, 如果使用tinyint(1)，mysql连接没加tinyInt1isBit=false，默认mysql驱动会把值转成boolean
     */
    private Integer type;
    /**
     * 自定义填充的创建时间
     */
    private Date ctime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        ", id=" + id +
        ", name=" + name +
        ", age=" + age +
        ", type=" + type +
        ", ctime=" + ctime +
        "}";
    }
}
