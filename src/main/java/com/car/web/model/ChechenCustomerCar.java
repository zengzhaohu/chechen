package com.car.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "chechen_customer_car")
public class ChechenCustomerCar extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerId")
    private Long customerid;

    @Column(name = "carId")
    private Long carid;

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
     * @return customerId
     */
    public Long getCustomerid() {
        return customerid;
    }

    /**
     * @param customerid
     */
    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
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