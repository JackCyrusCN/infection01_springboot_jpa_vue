package org.eastwill.domain.infection;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "case_report", schema = "public")
public class CaseReport implements Serializable{
	private static final long serialVersionUID = 7187628714679791771L;
	
	//主键
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq", unique = true, length = 64)
    private Long seq;  
	
	//患者号
	@Column(name = "pid", length = 30)
    private String pid;  
	
	//患者姓名
	@Column(name = "patient_name", length = 50)
    private String patientName;
	
	//患者类别(门诊、住院)
	@Column(name = "patient_type", length = 10)
    private String patientType;  
	
	//性别
	@Column(name = "gender", length = 2)
    private String gender;  
	
	//年龄
	@Column(name = "age", length = 4)
    private Integer age;
	
	//年龄单位
	@Column(name = "age_unit", length = 4)
    private String ageUnit;
	
	//入院时间
	@Column(name = "admission_time", length = 64)
    private Date admissionTime;
	
	//入院诊断编码
	@Column(name = "admission_diag_code", length = 255)
    private String admissionDiagCode;
	
	//入院诊断名称
	@Column(name = "admission_diag_name", length = 255)
    private String admissionDiagName;
	
	//感染时间
	@Column(name = "infection_time", length = 64)
    private Date infectionTime;
	
	//感染诊断编码
	@Column(name = "infection_diag_code", length = 255)
    private String infectionDiagCode;
	
	//感染诊断名称
	@Column(name = "infection_diag_name", length = 255)
    private String infectionDiagName;
	
	//是否病原学检查
	@Column(name = "etiologic_ex", length = 255)
    private String etiologicEx;
	
	//病原学检查标本名称
	@Column(name = "etiologic_spec_name", length = 255)
    private String etiologicSpecName;
	
	//病原体编码
	@Column(name = "pathogen_code", length = 255)
    private String pathogenCode;
	
	//病原体名称
	@Column(name = "pathogen_name", length = 255)
    private String pathogenName;
	
	//易感因素(用|分开)
	@Column(name = "pre_factor", length = 255)
    private String preFactor;
	
	//易感因素其他
	@Column(name = "pre_factor_else", length = 255)
    private String preFactorElse;
	
	//备注
	@Column(name = "remark", length = 255)
    private String remark;
	
	//报告人
	@Column(name = "op_code", length = 10)
    private String opCode;
	
	//报告科室
	@Column(name = "op_depid", length = 10)
    private String opDepid;
	
	//报告时间
	@Column(name = "op_time", length = 10)
    private Date opTime;
}
