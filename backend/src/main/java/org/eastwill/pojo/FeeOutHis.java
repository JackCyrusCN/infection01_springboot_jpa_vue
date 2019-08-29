package org.eastwill.pojo;

public class FeeOutHis {
	private long seq;
	private String pid;
	private String patientName;
	private String deptCode;
	private String doctorCode;
	private String itemCode;
	private String itemName;
	private String units;
	private Double price;
	private Double quantity;
	private Integer days;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private String cashtime;
	private String cashOpcode;
	private String prescStatus;
	private String dispDept;
	private String prescNo;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private String calTime;
	private String calOpcode;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private String payTime;
	private String payOpcode;
	private String drugSpec;
	
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
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getCashtime() {
		return cashtime;
	}
	public void setCashtime(String cashtime) {
		this.cashtime = cashtime;
	}
	public String getCashOpcode() {
		return cashOpcode;
	}
	public void setCashOpcode(String cashOpcode) {
		this.cashOpcode = cashOpcode;
	}
	public String getPrescStatus() {
		return prescStatus;
	}
	public void setPrescStatus(String prescStatus) {
		this.prescStatus = prescStatus;
	}
	public String getDispDept() {
		return dispDept;
	}
	public void setDispDept(String dispDept) {
		this.dispDept = dispDept;
	}
	public String getPrescNo() {
		return prescNo;
	}
	public void setPrescNo(String prescNo) {
		this.prescNo = prescNo;
	}
	public String getCalTime() {
		return calTime;
	}
	public void setCalTime(String calTime) {
		this.calTime = calTime;
	}
	public String getCalOpcode() {
		return calOpcode;
	}
	public void setCalOpcode(String calOpcode) {
		this.calOpcode = calOpcode;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getPayOpcode() {
		return payOpcode;
	}
	public void setPayOpcode(String payOpcode) {
		this.payOpcode = payOpcode;
	}
	public String getDrugSpec() {
		return drugSpec;
	}
	public void setDrugSpec(String drugSpec) {
		this.drugSpec = drugSpec;
	}	
}
