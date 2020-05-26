package com.railone.open.api.util;


import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/**
 * RSA加密处理工具类
 *
 * 
 */
public class RsaUtils {

  /** 加密算法RSA */
  public static final String KEY_ALGORITHM = "RSA";
  /** 签名算法 */
  public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

  public static final String SHA256WITHRSA = "SHA256WithRSA";
  /** 获取公钥的key */
  public static final String PUBLIC_KEY = "RSAPublicKey";
  /** 获取私钥的key */
  public static final String PRIVATE_KEY = "RSAPrivateKey";
  /** RSA最大加密明文大小 */
  private static final int MAX_ENCRYPT_BLOCK = 117;
  /** RSA最大解密密文大小 */
  private static final int MAX_DECRYPT_BLOCK = 128;

  /**
   * 私钥解密
   *
   * @param encryptedData 已加密数据
   * @param privateKey 私钥(BASE64编码)
   * @return byte[]
   */
  public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) {
    try {
      byte[] keyBytes = Base64Utils.decode(privateKey);
      PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
      KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
      Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
      Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
      cipher.init(Cipher.DECRYPT_MODE, privateK);
      int inputLen = encryptedData.length;
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      int offSet = 0;
      byte[] cache;
      int i = 0;
      while (inputLen - offSet > 0) {
        if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
          cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
        } else {
          cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
        }
        out.write(cache, 0, cache.length);
        i++;
        offSet = i * MAX_DECRYPT_BLOCK;
      }
      byte[] decryptedData = out.toByteArray();
      out.close();
      return decryptedData;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
  /**
   * 公钥加密
   *
   * @param data 源数据
   * @param publicKey 公钥(BASE64编码)
   * @return byte[]
   */
  public static byte[] encryptByPublicKey(byte[] data, String publicKey) {
    try {
      byte[] keyBytes = Base64Utils.decode(publicKey);
      X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
      KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
      Key publicK = keyFactory.generatePublic(x509KeySpec);
      // 对数据加密
      Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
      cipher.init(Cipher.ENCRYPT_MODE, publicK);
      int inputLen = data.length;
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      int offSet = 0;
      byte[] cache;
      int i = 0;
      // 对数据分段加密
      while (inputLen - offSet > 0) {
        if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
          cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
        } else {
          cache = cipher.doFinal(data, offSet, inputLen - offSet);
        }
        out.write(cache, 0, cache.length);
        i++;
        offSet = i * MAX_ENCRYPT_BLOCK;
      }
      byte[] encryptedData = out.toByteArray();
      out.close();
      return encryptedData;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }




  /**
   * 获取私钥
   * @param keyMap 密钥对
   * @return String
   */
  public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
    Key key = (Key) keyMap.get(PRIVATE_KEY);
    return Base64Utils.encode(key.getEncoded());
  }

  /**
   * 获取公钥
   * @param keyMap 密钥对
   * @return String
   */
  public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
    Key key = (Key) keyMap.get(PUBLIC_KEY);
    return Base64Utils.encode(key.getEncoded());
  }

  /**
   * 生成密钥对(公钥和私钥)
   * @return Map<String, Object>
   */
  public static Map<String, Object> genKeyPair() throws Exception {
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
    keyPairGen.initialize(1024);
    KeyPair keyPair = keyPairGen.generateKeyPair();
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    Map<String, Object> keyMap = new HashMap<>(16);
    keyMap.put(PUBLIC_KEY, publicKey);
    keyMap.put(PRIVATE_KEY, privateKey);
    return keyMap;
  }

  public static void main(String[] args) throws Exception {
    Map<String, Object> map = RsaUtils.genKeyPair();
    String publicKey = RsaUtils.getPublicKey(map);
    System.out.println("String publicKey= \""+publicKey+"\"");
    String privateKey = RsaUtils.getPrivateKey(map);
    System.out.println("String privateKey= \""+privateKey+"\"");
    String data = "12345678a";
    byte[] endata = RsaUtils.encryptByPublicKey(data.getBytes(),publicKey);
    System.out.println(Base64Utils.encode(endata));
    String rspContent = new String(RsaUtils.decryptByPrivateKey(endata, privateKey));
    System.out.println(rspContent);
  }
}
