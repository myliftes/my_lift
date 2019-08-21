package com.chillax.dto;

public class Courier {

	private Integer id; // 主键
	private String courierNum; // 快递员工号
	private String name; // 快递员姓名
	private String telephone; // 快递员联系电话
	private String pda; // PDA号
	private Character deltag; // 作废标志 1 为标记作废
	private String checkPwd; // 查台密码
	private String type; // 取件员类型
	private String company; // 单位
	private String vehicleType; // 车辆类型
	private String vehicleNum; // 车牌号

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourierNum() {
		return courierNum;
	}

	public void setCourierNum(String courierNum) {
		this.courierNum = courierNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPda() {
		return pda;
	}

	public void setPda(String pda) {
		this.pda = pda;
	}

	public Character getDeltag() {
		return deltag;
	}

	public void setDeltag(Character deltag) {
		this.deltag = deltag;
	}

	public String getCheckPwd() {
		return checkPwd;
	}

	public void setCheckPwd(String checkPwd) {
		this.checkPwd = checkPwd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	@Override
	public String toString() {
		return "Courier [id=" + id + ", courierNum=" + courierNum + ", name=" + name + ", telephone=" + telephone
				+ ", pda=" + pda + ", deltag=" + deltag + ", checkPwd=" + checkPwd + ", type=" + type + ", company="
				+ company + ", vehicleType=" + vehicleType + ", vehicleNum=" + vehicleNum + "]";
	}

}
