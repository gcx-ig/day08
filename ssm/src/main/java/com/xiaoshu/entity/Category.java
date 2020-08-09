package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "contentcategory")
public class Category implements Serializable {
    @Id
    @Column(name = "contenCategoryId")
    private Integer contencategoryid;

    private String categoryname;

    private String status;

    private Date ceratetime;

    private static final long serialVersionUID = 1L;

    /**
     * @return contenCategoryId
     */
    public Integer getContencategoryid() {
        return contencategoryid;
    }

    /**
     * @param contencategoryid
     */
    public void setContencategoryid(Integer contencategoryid) {
        this.contencategoryid = contencategoryid;
    }

    /**
     * @return categoryname
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * @param categoryname
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
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
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return ceratetime
     */
    public Date getCeratetime() {
        return ceratetime;
    }

    /**
     * @param ceratetime
     */
    public void setCeratetime(Date ceratetime) {
        this.ceratetime = ceratetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contencategoryid=").append(contencategoryid);
        sb.append(", categoryname=").append(categoryname);
        sb.append(", status=").append(status);
        sb.append(", ceratetime=").append(ceratetime);
        sb.append("]");
        return sb.toString();
    }
}