package org.eastwill.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "opuser", schema = "public")
public class Opuser {
	
	@Id
	@Column(name = "seq", unique = true, nullable = false)
	private Long seq;
	
	@Column(name = "operator_code")
	private String operatorCode;
	
	@Column(name = "operator_name")
	private String operatorName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "is_lock")
	private String isLock;
	
	@Column(name = "create_operator")
	private String createOperator;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "modify_operator")
	private String modifyOperator;
	
	@Column(name = "modify_time")
	private Date modifyTime;

	public Opuser(String operatorCode, String password) {
		super();
		this.operatorCode = operatorCode;
		this.password = password;
	}
	
	
	/*private Set<String> role;

    private Set<String> permission;

	public Opuser(String operatorCode, String password, Set<String> role, Set<String> permission) {
		super();
		this.operatorCode = operatorCode;
		this.password = password;
		this.role = role;
		this.permission = permission;
	}*/
    
    
}
