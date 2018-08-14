package com.car.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "chechen_maintenance_item_goods")
public class ChechenMaintenanceItemGoods extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "maintenanceId")
    private Long maintenanceid;

    @Column(name = "itemId")
    private Long itemid;

    @Column(name = "goodId")
    private Long goodid;

    private String number;

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
     * @return maintenanceId
     */
    public Long getMaintenanceid() {
        return maintenanceid;
    }

    /**
     * @param maintenanceid
     */
    public void setMaintenanceid(Long maintenanceid) {
        this.maintenanceid = maintenanceid;
    }

    /**
     * @return itemId
     */
    public Long getItemid() {
        return itemid;
    }

    /**
     * @param itemid
     */
    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    /**
     * @return goodId
     */
    public Long getGoodid() {
        return goodid;
    }

    /**
     * @param goodid
     */
    public void setGoodid(Long goodid) {
        this.goodid = goodid;
    }

    /**
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
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