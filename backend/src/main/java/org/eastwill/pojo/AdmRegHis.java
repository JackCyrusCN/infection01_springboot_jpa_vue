package org.eastwill.pojo;

public class AdmRegHis {
	private long seq;
	private String pid;
	private String exPid;
	private String patientName;
	private String idCardNo;
	private String insuranceNo;
	private String bedNmb;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private String admDate;
	private String deptCode;
	private String doctorCode;
	private Double depositAmount;
	private Double depositLeft;
	private String inType;
	private Double allSum;
	
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
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
	public String getBedNmb() {
		return bedNmb;
	}
	public void setBedNmb(String bedNmb) {
		this.bedNmb = bedNmb;
	}
	public String getAdmDate() {
		return admDate;
	}
	public void setAdmDate(String admDate) {
		this.admDate = admDate;
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
	public Double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public Double getDepositLeft() {
		return depositLeft;
	}
	public void setDepositLeft(Double depositLeft) {
		this.depositLeft = depositLeft;
	}
	public String getInType() {
		return inType;
	}
	public void setInType(String inType) {
		this.inType = inType;
	}
	public Double getAllSum() {
		return allSum;
	}
	public void setAllSum(Double allSum) {
		this.allSum = allSum;
	}	
}
