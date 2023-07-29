package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("projectfangan")
public class    ProjectFangAnEntity {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String biaoti;
    private String  oldremark;
    private String          newremark;
    private String  pinkunhu;
    private String          pinkunhuname;
    private String  yonghuname;
    private String           price;
    private String   projectid;

    private String   projectname;


    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    /**
     * 封面
     */

    private String fengmian;



    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;
    /**
     * 发布时间
     */

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    @DateTimeFormat
    private Date fabushijian;


    private String wordb;

    public String getWordb() {
        return wordb;
    }

    public void setWordb(String wordb) {
        this.wordb = wordb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }

    public String getOldremark() {
        return oldremark;
    }

    public void setOldremark(String oldremark) {
        this.oldremark = oldremark;
    }

    public String getNewremark() {
        return newremark;
    }

    public void setNewremark(String newremark) {
        this.newremark = newremark;
    }

    public String getPinkunhu() {
        return pinkunhu;
    }

    public void setPinkunhu(String pinkunhu) {
        this.pinkunhu = pinkunhu;
    }

    public String getPinkunhuname() {
        return pinkunhuname;
    }

    public void setPinkunhuname(String pinkunhuname) {
        this.pinkunhuname = pinkunhuname;
    }

    public String getYonghuname() {
        return yonghuname;
    }

    public void setYonghuname(String yonghuname) {
        this.yonghuname = yonghuname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getFengmian() {
        return fengmian;
    }

    public void setFengmian(String fengmian) {
        this.fengmian = fengmian;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getFabushijian() {
        return fabushijian;
    }

    public void setFabushijian(Date fabushijian) {
        this.fabushijian = fabushijian;
    }
}
