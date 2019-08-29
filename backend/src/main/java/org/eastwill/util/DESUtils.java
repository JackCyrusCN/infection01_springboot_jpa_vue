package org.eastwill.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


public class DESUtils {
    
    /**
     * DES密钥
     */
    private static String key = "eastwill.org";
    
    /**
     * DES加密
     * @param data:需要加密的数据
     * @return
     */
    public static String encryptDES(String data) throws Exception
    {
        String s = null;
        if ( data != null )
        {
            //DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            //从原始密钥数据创建DESKeySpec对象
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
            //创建一个密钥工厂，用它将DESKeySpec转化成SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKeySpec);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密钥初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
            //将加密后的数据编码成字符串
            Base64Utils base64Utils = new Base64Utils();
            s = base64Utils.encode(cipher.doFinal(data.getBytes()));
        }
        return s;
    }
    
    /**
     * DES解密
     * @param data:需要解密的数据
     * @return
     * @throws Exception
     */
    public static String decryptDES(String data) throws Exception
    {
        String s = null;
        if ( data != null )
        {
            //DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            //从原始密钥数据创建DESKeySpec对象
            DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
            //创建一个密钥工厂，用它将DESKeySpec转化成SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKeySpec);
            //Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密钥初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
            //将加密后的数据解码再解密
            Base64Utils base64Utils = new Base64Utils();
            byte[] buf = cipher.doFinal(base64Utils.decode(data));
            s = new String(buf);
        }
        return s;
    }
   /*
    public static void main(String[] args)
    {
        String data = "1491474372";
        //加密
        try
        {
            String str1 = encryptDES(data);
            System.out.println("加密后为:str1=" + str1);
            //解密
            String str2 = decryptDES(str1);
            System.out.println("解密后为:str2=" + str2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
*/
}
