package com.railone.open.api.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.util.encoders.Base64;

public class Base64Utils {

  /** 文件读取缓冲区大小 */
  private static final int CACHE_SIZE = 1024;

  /** BASE64字符串解码为二进制数据 */
  public static byte[] decode(String base64) throws Exception {
    return Base64.decode(base64.getBytes());
  }

  /** 二进制数据编码为BASE64字符串 */
  public static String encode(byte[] bytes) throws Exception {
    return new String(Base64.encode(bytes));
  }

  /**
   * 将文件编码为BASE64字符串
   *
   * <p>大文件慎用，可能会导致内存溢出
   *
   * @param filePath 文件绝对路径
   */
  public static String encodeFile(String filePath) throws Exception {
    byte[] bytes = fileToByte(filePath);
    return encode(bytes);
  }

  /**
   * BASE64字符串转回文件
   *
   * @param filePath 文件绝对路径
   * @param base64 编码字符串
   */
  public static void decodeToFile(String filePath, String base64) throws Exception {
    byte[] bytes = decode(base64);
    byteArrayToFile(bytes, filePath);
  }

  /**
   * 文件转换为二进制数组
   *
   * @param filePath 文件路径
   */
  public static byte[] fileToByte(String filePath) throws Exception {
    byte[] data = new byte[0];
    File file = new File(filePath);
    if (file.exists()) {
      FileInputStream in = new FileInputStream(file);
      ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
      byte[] cache = new byte[CACHE_SIZE];
      int nRead = 0;
      while ((nRead = in.read(cache)) != -1) {
        out.write(cache, 0, nRead);
        out.flush();
      }
      out.close();
      in.close();
      data = out.toByteArray();
    }
    return data;
  }

  /**
   * 二进制数据写文件
   *
   * @param bytes 二进制数据
   * @param filePath 文件生成目录
   */
  public static void byteArrayToFile(byte[] bytes, String filePath) throws Exception {
    InputStream in = new ByteArrayInputStream(bytes);
    File destFile = new File(filePath);
    if (!destFile.getParentFile().exists()) {
      destFile.getParentFile().mkdirs();
    }
    destFile.createNewFile();
    OutputStream out = new FileOutputStream(destFile);
    byte[] cache = new byte[CACHE_SIZE];
    int nRead = 0;
    while ((nRead = in.read(cache)) != -1) {
      out.write(cache, 0, nRead);
      out.flush();
    }
    out.close();
    in.close();
  }

  public static String getBase64(byte[] b) {
    byte[] rb = org.apache.commons.codec.binary.Base64.encodeBase64(b);
    if (rb == null) {
      return null;
    }
    try {
      return new String(rb, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static byte[] getBytesBase64(String s) {
    if (s == null) {
      return null;
    }
    try {
      return org.apache.commons.codec.binary.Base64.decodeBase64(s.getBytes("UTF-8"));
    } catch (Exception e) {
      return null;
    }
  }
}
