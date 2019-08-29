package org.eastwill.pojo;

import java.util.Date;

public class OutReg {
	private String pid;
	private String exPid;  //商户订单号
	private String patientName;	  
	private String deptCode;
	private String doctorCode;
	private String idCardNo;
	private String insuranceNo;
	private String regType;
	private Double regPrice;
	private Double checkPrice;
	private Date regTime;
	private String regOpcode;
	private String consultMark;
	private String regCancelMark;
	private String indicator;  //返回openid
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getExPid() {
		return exPid;
	}
	public void setExPid(String exPid) {
		this.exPid = exPid;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDoctorCode() {
		return doctorCode;
	}
	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getInsuranceNo() {
		return insuranceNo;
	}
	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}
	public String getRegType() {
		return regType;
	}
	public void setRegType(String regType) {
		this.regType = regType;
	}
	public Double getRegPrice() {
		return regPrice;
	}
	public void setRegPrice(Double regPrice) {
		this.regPrice = regPrice;
	}
	public Double getCheckPrice() {
		return checkPrice;
	}
	public void setCheckPrice(Double checkPrice) {
		this.checkPrice = checkPrice;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public String getRegOpcode() {
		return regOpcode;
	}
	public void setRegOpcode(String regOpcode) {
		this.regOpcode = regOpcode;
	}
	public String getConsultMark() {
		return consultMark;
	}
	public void setConsultMark(String consultMark) {
		this.consultMark = consultMark;
	}
	public String getRegCancelMark() {
		return regCancelMark;
	}
	public void setRegCancelMark(String regCancelMark) {
		this.regCancelMark = regCancelMark;
	}
	
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
}
