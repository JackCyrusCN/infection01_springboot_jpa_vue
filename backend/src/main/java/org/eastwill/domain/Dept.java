package org.eastwill.domain;

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
@Table(name = "t_dept", schema = "public")
public class Dept {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id", length = 64)
	private Long deptId;
	
	@Column(name = "parent_id", length = 64)
	private Long  parentId;
	
	@Column(name = "dept_name", length = 254)
	private String deptName;
	
	@Column(name = "order_num", precision = 40,scale = 4)
	private Double orderNum;
	
	@Column(name = "create_time", length = 64)
	private Date createTime;
	
	@Column(name = "modify_time", length = 64)
	private Date modifyTime;
	
}
