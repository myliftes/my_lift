package com.chillax.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FixedArea {

	private String id; // 主键
	private String fixedAreaName; // 定区名称
	private String fixedAreaLeader;// 定区负责人
	private String telephone;// 联系电话
	private String company; // 所属单位
	private Date operatingTime;// 操作时间
	private String operator; // 操作员
	private String operatingCompany; // 操作单位
	private Set<SubArea> subareas = new HashSet<SubArea>(0);
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFixedAreaName() {
		return fixedAreaName;
	}
	public void setFixedAreaName(String fixedAreaName) {
		this.fixedAreaName = fixedAreaName;
	}
	public String getFixedAreaLeader() {
		return fixedAreaLeader;
	}
	public void setFixedAreaLeader(String fixedAreaLeader) {
		this.fixedAreaLeader = fixedAreaLeader;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public Set<SubArea> getSubareas() {
		return subareas;
	}
	public void setSubareas(Set<SubArea> subareas) {
		this.subareas = subareas;
	}
	@Override
	public String toString() {
		return "FixedArea [id=" + id + ", fixedAreaName=" + fixedAreaName + ", fixedAreaLeader=" + fixedAreaLeader
				+ ", telephone=" + telephone + ", company=" + company + ", operatingTime=" + operatingTime
				+ ", operator=" + operator + ", operatingCompany=" + operatingCompany + ", subareas=" + subareas + "]";
	}

}
