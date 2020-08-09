package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "tb_device")
public class Device implements Serializable {
    @Id
    @Column(name = "deviceId")
    private Integer deviceid;

    @Column(name = "device_type")
    private Integer deviceType;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "device_ram")
    private String deviceRam;

    private String color;

    private Integer price;

    private String status;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    private static final long serialVersionUID = 1L;

   

    public Integer getDeviceid() {
		return deviceid;
	}



	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
	}



	public Integer getDeviceType() {
		return deviceType;
	}



	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}



	public String getDeviceName() {
		return deviceName;
	}



	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}



	public String getDeviceRam() {
		return deviceRam;
	}



	public void setDeviceRam(String deviceRam) {
		this.deviceRam = deviceRam;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Date getCreatetime() {
		return createtime;
	}



	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Device(Integer deviceid, Integer deviceType, String deviceName, String deviceRam, String color,
			Integer price, String status, Date createtime) {
		super();
		this.deviceid = deviceid;
		this.deviceType = deviceType;
		this.deviceName = deviceName;
		this.deviceRam = deviceRam;
		this.color = color;
		this.price = price;
		this.status = status;
		this.createtime = createtime;
	}



	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deviceid=").append(deviceid);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", deviceRam=").append(deviceRam);
        sb.append(", color=").append(color);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}