package com.railone.open.api.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class AESUtil {
    private static final String CHARSET = "UTF-8";

    /**
     * "算法/模式/补码方式"
     */
    private static final String CIPHER = "AES/ECB/PKCS5Padding";

    private static final String ALGORITHM = "AES";

    public static String encrypt(String src, String secret)throws Exception{
        byte[] raw = secret.getBytes(CHARSET);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(src.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * 解密
     *
     * @param
     * @return
     */
    public static String decrypt(String src, String secret)throws Exception{
        byte[] raw = secret.getBytes(CHARSET);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] encrypted = Base64.getDecoder().decode(src);
        byte[] original = cipher.doFinal(encrypted);
        String originalString = new String(original, CHARSET);
        return originalString;
    }

}
