package org.eastwill.util;

import org.apache.commons.lang3.StringUtils;
import org.eastwill.domain.Opuser;
import org.eastwill.service.OpuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 系统工具类
 *
 * @author MrBird
 */
public class SystemUtils {

    private static Logger log = LoggerFactory.getLogger(SystemUtils.class);

    
    @Autowired
    private OpuserService opuserService;
    
    /**
     * 模拟两个用户
     *
     * @return List<User>
     */
    private static List<Opuser> opusers() {
        List<Opuser> opusers = new ArrayList<>();
        // 模拟两个用户：
        // 1. 用户名 admin，密码 123456，角色 admin（管理员），权限 "user:add"，"user:view"
        // 1. 用户名 scott，密码 123456，角色 regist（注册用户），权限 "user:view"
        opusers.add(new Opuser(
                "admin",
                "bfc62b3f67a4c3e57df84dad8cc48a3b"));//,
                //new HashSet<>(Collections.singletonList("admin")),
               // new HashSet<>(Arrays.asList("user:add", "user:view"))));
        /*opusers.add(new Opuser(
                "scott",
                "11bd73355c7bbbac151e4e4f943e59be",
                new HashSet<>(Collections.singletonList("regist")),
                new HashSet<>(Collections.singletonList("user:view"))));*/
        return opusers;
    }
    
    /*public static Opuser getOpuser(String operatorCode) {
        //List<Opuser> opusers = SystemUtils.opusers();
    	//List<Opuser> opusers = 
        //return opusers.stream().filter(opuser -> StringUtils.equalsIgnoreCase(operatorCode, opuser.getOperatorCode())).findFirst().orElse(null);
    }*/
}

