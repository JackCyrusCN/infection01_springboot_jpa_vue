package org.eastwill.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import org.eastwill.domain.User;

/**
 * 用户 加密工具
 * 生成随机salt
 * md5(md5(password))
 *
 * @author shimh
 * <p>
 * 2018�?1�?23�?
 */
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static String algorithmName = "md5";
    private static final int hashIterations = 2;

    public static void encryptPassword(User user) {

        //user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getUsername()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }

    public static void encryptPasswordByUserSalt(User user) {

        //user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getUsername()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
    
    public static String encrypt(String username, String password) {
		return new SimpleHash(algorithmName, password, ByteSource.Util.bytes(username.toLowerCase() + password),
			hashIterations).toHex();
    }
    
    public static String encrypt(String password) {
		return new SimpleHash(algorithmName, password).toHex();
    }
    
}