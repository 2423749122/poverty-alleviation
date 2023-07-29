package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@TableName("project")
public class ProjectEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ProjectEntity() {

    }

    public ProjectEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;
    private String worda;
    private String wordb;
    private String wordc;
    private String price;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat
    private Date addtime;

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

    public String getWorda() {
        return worda;
    }

    public void setWorda(String worda) {
        this.worda = worda;
    }

    public String getWordb() {
        return wordb;
    }

    public void setWordb(String wordb) {
        this.wordb = wordb;
    }

    public String getWordc() {
        return wordc;
    }

    public void setWordc(String wordc) {
        this.wordc = wordc;
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
