package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 志愿者招聘
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 
 */
@TableName("zhiyuanzhezhaopin")
public class ZhiyuanzhezhaopinEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhiyuanzhezhaopinEntity() {
		
	}
	
	public ZhiyuanzhezhaopinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 招聘标题
	 */
					
	private String zhaopinbiaoti;
	
	/**
	 * 职位
	 */
					
	private String zhiwei;
	
	/**
	 * 招聘要求
	 */
					
	private String zhaopinyaoqiu;
	
	/**
	 * 工资待遇
	 */
					
	private String gongzidaiyu;
	
	/**
	 * 工作地点
	 */
					
	private String gongzuodidian;
	
	/**
	 * 工作时间
	 */
					
	private String gongzuoshijian;
	
	/**
	 * 招聘人数
	 */
					
	private Integer zhaopinrenshu;
	
	/**
	 * 招聘时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date zhaopinshijian;
	
	/**
	 * 截止时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiezhishijian;
	
	/**
	 * 负责人
	 */
					
	private String fuzeren;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 发布日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date faburiqi;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：招聘标题
	 */
	public void setZhaopinbiaoti(String zhaopinbiaoti) {
		this.zhaopinbiaoti = zhaopinbiaoti;
	}
	/**
	 * 获取：招聘标题
	 */
	public String getZhaopinbiaoti() {
		return zhaopinbiaoti;
	}
	/**
	 * 设置：职位
	 */
	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}
	/**
	 * 获取：职位
	 */
	public String getZhiwei() {
		return zhiwei;
	}
	/**
	 * 设置：招聘要求
	 */
	public void setZhaopinyaoqiu(String zhaopinyaoqiu) {
		this.zhaopinyaoqiu = zhaopinyaoqiu;
	}
	/**
	 * 获取：招聘要求
	 */
	public String getZhaopinyaoqiu() {
		return zhaopinyaoqiu;
	}
	/**
	 * 设置：工资待遇
	 */
	public void setGongzidaiyu(String gongzidaiyu) {
		this.gongzidaiyu = gongzidaiyu;
	}
	/**
	 * 获取：工资待遇
	 */
	public String getGongzidaiyu() {
		return gongzidaiyu;
	}
	/**
	 * 设置：工作地点
	 */
	public void setGongzuodidian(String gongzuodidian) {
		this.gongzuodidian = gongzuodidian;
	}
	/**
	 * 获取：工作地点
	 */
	public String getGongzuodidian() {
		return gongzuodidian;
	}
	/**
	 * 设置：工作时间
	 */
	public void setGongzuoshijian(String gongzuoshijian) {
		this.gongzuoshijian = gongzuoshijian;
	}
	/**
	 * 获取：工作时间
	 */
	public String getGongzuoshijian() {
		return gongzuoshijian;
	}
	/**
	 * 设置：招聘人数
	 */
	public void setZhaopinrenshu(Integer zhaopinrenshu) {
		this.zhaopinrenshu = zhaopinrenshu;
	}
	/**
	 * 获取：招聘人数
	 */
	public Integer getZhaopinrenshu() {
		return zhaopinrenshu;
	}
	/**
	 * 设置：招聘时间
	 */
	public void setZhaopinshijian(Date zhaopinshijian) {
		this.zhaopinshijian = zhaopinshijian;
	}
	/**
	 * 获取：招聘时间
	 */
	public Date getZhaopinshijian() {
		return zhaopinshijian;
	}
	/**
	 * 设置：截止时间
	 */
	public void setJiezhishijian(Date jiezhishijian) {
		this.jiezhishijian = jiezhishijian;
	}
	/**
	 * 获取：截止时间
	 */
	public Date getJiezhishijian() {
		return jiezhishijian;
	}
	/**
	 * 设置：负责人
	 */
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：发布日期
	 */
	public void setFaburiqi(Date faburiqi) {
		this.faburiqi = faburiqi;
	}
	/**
	 * 获取：发布日期
	 */
	public Date getFaburiqi() {
		return faburiqi;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}
