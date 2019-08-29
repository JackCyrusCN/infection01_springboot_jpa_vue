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
@Table(name = "t_user_role", schema = "public")
public class UserRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq", unique = true, length = 64)
    private Long seq;
	
    @Column(name = "user_id", unique = false, length = 64)
    private Long userId;

    @Column(name = "role_id", unique = false, length = 64)
    private Long roleId;
	
}
