package org.eastwill.pojo;

import java.math.BigDecimal;

public class DepositHis {
	private long seq;
	private String pid;
	private String pname;
	private String idcard;
	private String mobile;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String admDate;
	private String feeType;
	private BigDecimal feeSum;
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String feeTime;
	private String openid;
	private String nickName;
	private String payNmb;
	
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
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAdmDate() {
		return admDate;
	}
	public void setAdmDate(String admDate) {
		this.admDate = admDate;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public BigDecimal getFeeSum() {
		return feeSum;
	}
	public void setFeeSum(BigDecimal feeSum) {
		this.feeSum = feeSum;
	}
	public String getFeeTime() {
		return feeTime;
	}
	public void setFeeTime(String feeTime) {
		this.feeTime = feeTime;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPayNmb() {
		return payNmb;
	}
	public void setPayNmb(String payNmb) {
		this.payNmb = payNmb;
	}	
}
