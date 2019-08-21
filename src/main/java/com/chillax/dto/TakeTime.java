package com.chillax.dto;

import java.util.Date;

public class TakeTime {

	private Integer id; // 主键
	private String name; // 收派时间名称
	private String normalWorkTime; // 平常上班时间
	private String normalDutyTime; // 平常下班时间
	private String satWorkTime; // 周六上班时间
	private String satDutyTime; // 周六下班时间
	private String sunWorkTime; // 周日上班时间
	private String sunDutyTime; // 周日下班时间
	private String status; // 状态
	private String company; // 所属公司
	private Date operatingTime;// 操作时间
	private String operator; // 操作员
	private String operatingCompany; // 操作单位

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

	public String getNormalWorkTime() {
		return normalWorkTime;
	}

	public void setNormalWorkTime(String normalWorkTime) {
		this.normalWorkTime = normalWorkTime;
	}

	public String getNormalDutyTime() {
		return normalDutyTime;
	}

	public void setNormalDutyTime(String normalDutyTime) {
		this.normalDutyTime = normalDutyTime;
	}

	public String getSatWorkTime() {
		return satWorkTime;
	}

	public void setSatWorkTime(String satWorkTime) {
		this.satWorkTime = satWorkTime;
	}

	public String getSatDutyTime() {
		return satDutyTime;
	}

	public void setSatDutyTime(String satDutyTime) {
		this.satDutyTime = satDutyTime;
	}

	public String getSunWorkTime() {
		return sunWorkTime;
	}

	public void setSunWorkTime(String sunWorkTime) {
		this.sunWorkTime = sunWorkTime;
	}

	public String getSunDutyTime() {
		return sunDutyTime;
	}

	public void setSunDutyTime(String sunDutyTime) {
		this.sunDutyTime = sunDutyTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getOperatingTime() {
		return operatingTime;
	}

	public void setOperatingTime(Date operatingTime) {
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

	@Override
	public String toString() {
		return "TakeTime [id=" + id + ", name=" + name + ", normalWorkTime=" + normalWorkTime + ", normalDutyTime="
				+ normalDutyTime + ", satWorkTime=" + satWorkTime + ", satDutyTime=" + satDutyTime + ", sunWorkTime="
				+ sunWorkTime + ", sunDutyTime=" + sunDutyTime + ", status=" + status + ", company=" + company
				+ ", operatingTime=" + operatingTime + ", operator=" + operator + ", operatingCompany="
				+ operatingCompany + "]";
	}

}
