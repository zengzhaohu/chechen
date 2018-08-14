package com.car.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "chechen_maintenance")
public class ChechenMaintenance extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "carId")
    private Long carid;

    private String name;

    private Date date;

    @Column(name = "getDate")
    private Date getdate;

    private String cost;

    @Column(name = "deFlag")
    private String deflag;

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
     * @return carId
     */
    public Long getCarid() {
        return carid;
    }

    /**
     * @param carid
     */
    public void setCarid(Long carid) {
        this.carid = carid;
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
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return getDate
     */
    public Date getGetdate() {
        return getdate;
    }

    /**
     * @param getdate
     */
    public void setGetdate(Date getdate) {
        this.getdate = getdate;
    }

    /**
     * @return cost
     */
    public String getCost() {
        return cost;
    }

    /**
     * @param cost
     */
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * @return deFlag
     */
    public String getDeflag() {
        return deflag;
    }

    /**
     * @param deflag
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