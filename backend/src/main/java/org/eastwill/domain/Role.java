package org.eastwill.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "t_role", schema = "public")
public class Role  implements Serializable {

    private static final long serialVersionUID = -1714476694755654924L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", unique = true, length = 10)
    private Long roleId;

    @Column(name = "role_name", unique = true, length = 10)
    private String roleName;

    @Column(name = "remark", unique = true, length = 10)
    private String remark;

    @Column(name = "create_time", unique = true, length = 10)
    private Date createTime;

    @Column(name = "modify_time", unique = true, length = 10)
    private Date modifyTime;
    
//    @ManyToMany(targetEntity = User.class)
//    @JoinTable(name = "t_user_role",
//    		//joinColumns,当前对象在中间表的外键
//    		joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
//    		//inverseJoinColumns, 对方对象在中间表的外键
//    		inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
//    )
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users = new HashSet<>();

    private transient String createTimeFrom;
    private transient String createTimeTo;
    private transient String menuId;


}