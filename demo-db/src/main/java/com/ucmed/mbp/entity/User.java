package com.ucmed.mbp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhch
 * @since 2019-05-27
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    private String address;

}
