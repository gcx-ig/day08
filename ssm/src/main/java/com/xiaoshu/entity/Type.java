package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "device_type")
public class Type implements Serializable {
    @Id
    @Column(name = "device_type_id")
    private Integer deviceTypeId;

    @Column(name = "type_name")
    private String typeName;

    private String status;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return device_type_id
     */
    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    /**
     * @param deviceTypeId
     */
    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    /**
     * @return type_name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
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
     * @return createtime
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deviceTypeId=").append(deviceTypeId);
        sb.append(", typeName=").append(typeName);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}