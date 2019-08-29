package org.eastwill.views;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "user_view", schema = "public")
public class UserView  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "user_id",unique = true, length = 64)
    private Long userId;

    @Column(name = "username", length = 254)
    private String username;

    @Column(name = "password", length = 254)
    private String password;

    @Column(name = "dept_id", length = 64)
    private Long deptId;

//    @Column(name = "dept_name", length = 40)
//    private transient String deptName;

    @Column(name = "email", length = 254)
    private String email;

    @Column(name = "mobile", length = 254)
    private String mobile;

    @Column(name = "status", length = 254)
    private String status;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "modify_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;

    @Column(name = "last_login_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;

    @Column(name = "ssex", length = 254)
    private String ssex;

    @Column(name = "description", length = 254)
    private String description;

    @Column(name = "avatar", length = 254)
    private String avatar;

    @Column(name = "real_name", length = 254)
    private String realName;
    
    @Column(name = "role_id", length = 254)
    private String roleId;
    
    @Column(name = "role_name", length = 254)
    private String roleName;
    
    @Column(name = "dept_name", length = 254)
    private String deptName;
    
    @Column(name = "parent_id", length = 254)
    private String parentId;
    
    private transient String createTimeFrom;
    
    private transient String createTimeTo;

}
