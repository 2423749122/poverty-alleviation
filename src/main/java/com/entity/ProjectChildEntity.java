package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

@TableName("projectchild")
public class ProjectChildEntity {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private String pinkunhu;
    private String pinkunhuname;
    private String yonghuname;
    private String price;
    private Date addtime;

    private Long projectid;
    private Long fanganid;
    private String fanganname;

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public Long getFanganid() {
        return fanganid;
    }

    public void setFanganid(Long fanganid) {
        this.fanganid = fanganid;
    }

    public String getFanganname() {
        return fanganname;
    }

    public void setFanganname(String fanganname) {
        this.fanganname = fanganname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}
