package org.eastwill.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "t_menu", schema = "public")
public class Menu implements Serializable {

    private static final long serialVersionUID = 7187628714679791771L;

    public static final String TYPE_MENU = "0";

    public static final String TYPE_BUTTON = "1";

    //@NotBlank
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id", unique = true, length = 64)
    private Long menuId;

    //@NotBlank
    @Column(name = "parent_id", length = 64)
    private Long parentId;

    @Column(name = "menu_name", length = 64)
    private String menuName;

    @Column(name = "path", length = 64)
    private String path;

    @Column(name = "component", length = 64)
    private String component;

    @Column(name = "perms", length = 64)
    private String perms;

    @Column(name = "icon", length = 64)
    private String icon;

    @Column(name = "type", length = 64)
    private String type;

    @Column(name = "order_num", length = 64)
    private Double orderNum;

    @Column(name = "create_time", length = 64)
    private Date createTime;

    @Column(name = "modify_time", length = 64)
    private Date modifyTime;
    
    //cyrus
    @Column(name = "hidden", length = 1)
    private String hidden;

    private transient String createTimeFrom;
    private transient String createTimeTo;
	

}