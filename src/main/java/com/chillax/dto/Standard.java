package com.chillax.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Standard {
	private Integer id; // 主键
	private String name; // 标准名称
	private Double minWeight; // 最小重量
	private Double maxWeight; // 最大重量
	private Double minLength; // 最小长度
	private Double maxLength; // 最大重量
	private String operatingTime;// 操作时间
	private String operator; // 操作员
	private String operatingCompany; // 操作单位
	private String creator;// 创建责任者
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date create_time;// 创建时间
	private String revisor;// 修改人
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date revice_time;// 修改时间
	private String verison;// 版本号

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(Double minWeight) {
		this.minWeight = minWeight;
	}

	public Double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(Double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Double getMinLength() {
		return minLength;
	}

	public void setMinLength(Double minLength) {
		this.minLength = minLength;
	}

	public Double getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Double maxLength) {
		this.maxLength = maxLength;
	}

	public String getOperatingTime() {
		return operatingTime;
	}

	public void setOperatingTime(String operatingTime) {
		this.operatingTime = operatingTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperatingCompany() {
		return operatingCompany;
	}

	public void setOperatingCompany(String operatingCompany) {
		this.operatingCompany = operatingCompany;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getRevisor() {
		return revisor;
	}

	public void setRevisor(String revisor) {
		this.revisor = revisor;
	}

	public Date getRevice_time() {
		return revice_time;
	}

	public void setRevice_time(Date revice_time) {
		this.revice_time = revice_time;
	}

	public String getVerison() {
		return verison;
	}

	public void setVerison(String verison) {
		this.verison = verison;
	}

	@Override
	public String toString() {
		return "Standard [id=" + id + ", name=" + name + ", minWeight=" + minWeight + ", maxWeight=" + maxWeight
				+ ", minLength=" + minLength + ", maxLength=" + maxLength + ", operatingTime=" + operatingTime
				+ ", operator=" + operator + ", operatingCompany=" + operatingCompany + ", creator=" + creator
				+ ", create_time=" + create_time + ", revisor=" + revisor + ", revice_time=" + revice_time
				+ ", verison=" + verison + "]";
	}

}
