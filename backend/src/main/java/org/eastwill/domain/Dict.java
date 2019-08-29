package org.eastwill.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "t_dict", schema = "public")
public class Dict  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dict_id", unique = true, length = 64)
	private Long dictId;
	
	@Column(name = "keyy", length = 64)
	private Long keyy;
	
	@Column(name = "valuee", length = 254)
	private String valuee;
	
	@Column(name = "field_name", length = 254)
	private String filedName;
	
	@Column(name = "table_name", length = 254)
	private String tableName;
}
