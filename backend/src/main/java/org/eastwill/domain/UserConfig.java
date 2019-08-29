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
@Table(name = "t_user_config", schema = "public")
public class UserConfig implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_THEME = "light";
    public static final String DEFAULT_LAYOUT = "head";
    public static final String DEFAULT_MULTIPAGE = "0";
    public static final String DEFAULT_FIX_SIDERBAR = "1";
    public static final String DEFAULT_FIX_HEADER = "1";
    public static final String DEFAULT_COLOR = "rgb(66, 185, 131)";

    /**
     * 用户 ID
     */
    @Id
    @Column(name = "user_id", length = 64)
    private Long userId;

    /**
     * 系统主题 dark暗色风格，light明亮风格
     */
    
    @Column(name = "theme", length = 254)
    private String theme;

    /**
     * 系统布局 side侧边栏，head顶部栏
     */
    
    @Column(name = "layout", length = 254)
    private String layout;

    /**
     * 页面风格 1多标签页 0单页
     */
    
    @Column(name = "multi_page", length = 254)
    private String multiPage;

    /**
     * 页面滚动是否固定侧边栏 1固定 0不固定
     */
    
    @Column(name = "fix_siderbar", length = 254)
    private String fixSiderbar;

    /**
     * 页面滚动是否固定顶栏 1固定 0不固定
     */
    
    @Column(name = "fix_header", length = 254)
    private String fixHeader;

    /**
     * 主题颜色 RGB值
     */
    
    @Column(name = "color", length = 254)
    private String color;

}