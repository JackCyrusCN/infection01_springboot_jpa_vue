package org.eastwill.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
public class AdmReg implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long seq;
	private String pid;
	private String patientName;
	private String gender;
	private Integer age;
	private String ageUnit;
	private String admissionDate;
	
}
