package com.chillax.dto;

public class SubArea {

	private String id;
	private String startNum; // 起始号
	private String endNum; // 终止号
	private Character single; // 单双号
	private String keyWords; // 关键字
	private String assistKeyWords; // 辅助关键字
	private Area area; // 区域
	private FixedArea fixedArea; // 定区
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStartNum() {
		return startNum;
	}
	public void setStartNum(String startNum) {
		this.startNum = startNum;
	}
	public String getEndNum() {
		return endNum;
	}
	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}
	public Character getSingle() {
		return single;
	}
	public void setSingle(Character single) {
		this.single = single;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getAssistKeyWords() {
		return assistKeyWords;
	}
	public void setAssistKeyWords(String assistKeyWords) {
		this.assistKeyWords = assistKeyWords;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public FixedArea getFixedArea() {
		return fixedArea;
	}
	public void setFixedArea(FixedArea fixedArea) {
		this.fixedArea = fixedArea;
	}
	@Override
	public String toString() {
		return "SubArea [id=" + id + ", startNum=" + startNum + ", endNum=" + endNum + ", single=" + single
				+ ", keyWords=" + keyWords + ", assistKeyWords=" + assistKeyWords + ", area=" + area + ", fixedArea="
				+ fixedArea + "]";
	}

}
