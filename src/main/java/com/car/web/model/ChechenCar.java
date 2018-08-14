package com.car.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "chechen_car")
public class ChechenCar extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plateNumber")
    private String platenumber;

    @Column(name = "carType")
    private String cartype;

    private String age;

    private String mileage;

    @Column(name = "insuranceDate")
    private Date insurancedate;

    @Column(name = "serviceDate")
    private Date servicedate;

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
     * @return plateNumber
     */
    public String getPlatenumber() {
        return platenumber;
    }

    /**
     * @param platenumber
     */
    public void setPlatenumber(String platenumber) {
        this.platenumber = platenumber;
    }

    /**
     * @return carType
     */
    public String getCartype() {
        return cartype;
    }

    /**
     * @param cartype
     */
    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    /**
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return mileage
     */
    public String getMileage() {
        return mileage;
    }

    /**
     * @param mileage
     */
    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    /**
     * @return insuranceDate
     */
    public Date getInsurancedate() {
        return insurancedate;
    }

    /**
     * @param insurancedate
     */
    public void setInsurancedate(Date insurancedate) {
        this.insurancedate = insurancedate;
    }

    /**
     * @return serviceDate
     */
    public Date getServicedate() {
        return servicedate;
    }

    /**
     * @param servicedate
     */
    public void setServicedate(Date servicedate) {
        this.servicedate = servicedate;
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