package org.eastwill.pojo;

public class FeeSettleHis {
	private long seq;
	private String patientType;
	private String pid;
	private String patientName;
	private String cashOperator;
	private String receiptNumber;
	private String receiptTime;
	private String presStatus;
	private String invoiceNumber;
	private String cancelMark;
	private Double allSum;
	private Double paccSum;
	private Double cashSum;
	private Double hardSum;
	private Double backSum;
	private Double largeSum;
	
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getPatientType() {
		return patientType;
	}
	public void setPatientType(String patientType) {
		this.patientType = patientType;
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
	public String getCashOperator() {
		return cashOperator;
	}
	public void setCashOperator(String cashOperator) {
		this.cashOperator = cashOperator;
	}
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public String getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(String receiptTime) {
		this.receiptTime = receiptTime;
	}
	public String getPresStatus() {
		return presStatus;
	}
	public void setPresStatus(String presStatus) {
		this.presStatus = presStatus;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getCancelMark() {
		return cancelMark;
	}
	public void setCancelMark(String cancelMark) {
		this.cancelMark = cancelMark;
	}
	public Double getAllSum() {
		return allSum;
	}
	public void setAllSum(Double allSum) {
		this.allSum = allSum;
	}
	public Double getPaccSum() {
		return paccSum;
	}
	public void setPaccSum(Double paccSum) {
		this.paccSum = paccSum;
	}
	public Double getCashSum() {
		return cashSum;
	}
	public void setCashSum(Double cashSum) {
		this.cashSum = cashSum;
	}
	public Double getHardSum() {
		return hardSum;
	}
	public void setHardSum(Double hardSum) {
		this.hardSum = hardSum;
	}
	public Double getBackSum() {
		return backSum;
	}
	public void setBackSum(Double backSum) {
		this.backSum = backSum;
	}
	public Double getLargeSum() {
		return largeSum;
	}
	public void setLargeSum(Double largeSum) {
		this.largeSum = largeSum;
	}

}
