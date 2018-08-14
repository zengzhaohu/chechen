package com.car.web.model;

import javax.persistence.*;

public class Dictionary extends BaseEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 参数名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 参数CODE
     */
    @Column(name = "CODE")
    private String code;

    /**
     * 参数值
     */
    @Column(name = "VALUE")
    private String value;

    /**
     * 语言
     */
    @Column(name = "LANGUAGE")
    private String language;

    /**
     * 参数描述
     */
    @Column(name = "MESSAGE")
    private String message;

    /**
     * 作用范围
     */
    @Column(name = "SCOPE")
    private String scope;

    /**
     * 获取主键
     *
     * @return ID - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取参数名称
     *
     * @return NAME - 参数名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置参数名称
     *
     * @param name 参数名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取参数CODE
     *
     * @return CODE - 参数CODE
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置参数CODE
     *
     * @param code 参数CODE
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取参数值
     *
     * @return VALUE - 参数值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置参数值
     *
     * @param value 参数值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取语言
     *
     * @return LANGUAGE - 语言
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 设置语言
     *
     * @param language 语言
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 获取参数描述
     *
     * @return MESSAGE - 参数描述
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置参数描述
     *
     * @param message 参数描述
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取作用范围
     *
     * @return SCOPE - 作用范围
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置作用范围
     *
     * @param scope 作用范围
     */
    public void setScope(String scope) {
        this.scope = scope;
    }
}