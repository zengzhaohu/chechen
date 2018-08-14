package com.car.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "chechen_user")
public class ChechenUser extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userCode")
    private String usercode;

    @Column(name = "userName")
    private String username;

    private String password;

    private String status = "1";

    private String gender;

    private String phone;

    private String type;

    /**
     * 删除标记
     */
    @Column(name = "deFlag")
    private String deflag="0";

    @Column(name = "createTime")
    private Date createtime;

    private String creator;

    @Column(name = "updateTime")
    private Date updatetime;

    private String updator;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return userCode
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * @param usercode
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    /**
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取删除标记
     *
     * @return deFlag - 删除标记
     */
    public String getDeflag() {
        return deflag;
    }

    /**
     * 设置删除标记
     *
     * @param deflag 删除标记
     */
    public void setDeflag(String deflag) {
        this.deflag = deflag;
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return updateTime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return updator
     */
    public String getUpdator() {
        return updator;
    }

    /**
     * @param updator
     */
    public void setUpdator(String updator) {
        this.updator = updator;
    }
}