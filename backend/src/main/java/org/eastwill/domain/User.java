package org.eastwill.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.Data;



@Data
@Entity
@Table(name = "t_user", schema = "public")
public class User implements Serializable {

	/**
     * 账户状态
     */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";

    public static final String DEFAULT_AVATAR = "default.jpg";

    /**
     * 性别
     */
    public static final String SEX_MALE = "0";

    public static final String SEX_FEMALE = "1";

    public static final String SEX_UNKNOW = "2";

    // 默认密码
    public static final String DEFAULT_PASSWORD = "1234qwer";
	
    /**
     *
     */
    private static final long serialVersionUID = -4454737765850239378L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    // 排序字段
    //@JsonIgnoreProperties(value = {"users"})
//    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.PERSIST)
//    @JoinTable(name = "t_user_role",
//    		//joinColumns,当前对象在中间表的外键
//    		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
//    		//inverseJoinColumns, 对方对象在中间表的外键
//    		inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")}
//    )
//    private List<Role> roles = new ArrayList<Role>();
    
    private transient String roleId;
    private transient String roleName;
    private transient String deptName;
    
//    private String roleId;
//    
//    @Column(name = "role_name", length = 254)
//    private transient String roleName;

    private transient String sortField;

    // 排序规则 ascend 升序 descend 降序
    private transient String sortOrder;

    private transient String createTimeFrom;
    private transient String createTimeTo;

    private transient String id;

    /**
     * shiro-redis v3.1.0 必须要有 getAuthCacheKey()或者 getId()方法
     * # Principal id field name. The field which you can get unique id to identify this principal.
     * # For example, if you use UserInfo as Principal class, the id field maybe userId, userName, email, etc.
     * # Remember to add getter to this id field. For example, getUserId(), getUserName(), getEmail(), etc.
     * # Default value is authCacheKey or id, that means your principal object has a method called "getAuthCacheKey()" or "getId()"
     *
     * @return userId as Principal id field name
     */
    public Long getAuthCacheKey() {
        return userId;
    }



    
}
