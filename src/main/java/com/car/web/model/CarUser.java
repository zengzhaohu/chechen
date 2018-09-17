package com.car.web.model;

import javax.persistence.*;

public class CarUser extends BaseEntity {
    /**
     * primarykey
     */
    private Long id;

    private String name;

    private String phone;

    private String profession;

    private String descript;

    /**
     * 获取primarykey
     *
     * @return id - primarykey
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置primarykey
     *
     * @param id primarykey
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * @return profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * @return descript
     */
    public String getDescript() {
        return descript;
    }

    /**
     * @param descript
     */
    public void setDescript(String descript) {
        this.descript = descript;
    }
}