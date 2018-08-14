package com.car.web.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "chechen_item")
public class ChechenItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;

    @Column(name = "itemName")
    private String itemname;

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
     * @return item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return itemName
     */
    public String getItemname() {
        return itemname;
    }

    /**
     * @param itemname
     */
    public void setItemname(String itemname) {
        this.itemname = itemname;
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