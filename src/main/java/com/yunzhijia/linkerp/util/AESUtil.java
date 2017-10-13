package com.yunzhijia.linkerp.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Objects;

public class AESUtil {

    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final String ALGORITHM = "AES";

    /**
     * 加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] ciperData = encrypt(data.getBytes(CHARSET), key);
        return Base64.encodeBase64String(ciperData);
    }

    /**
     * <p>
     * 加密
     * </p>
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        Objects.requireNonNull(key, "aesKey为null");
        Key k = new SecretKeySpec(key.getBytes("UTF-8"), ALGORITHM);
        byte[] raw = k.getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);
    }

    /**
     * 解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception {
        byte[] plainData = decrypt(Base64.decodeBase64(data), key);
        return new String(plainData, CHARSET);
    }

    /**
     * <p>
     * 解密
     * </p>
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key) throws Exception {
        Objects.requireNonNull(key, "aesKey为null");
        Key k = new SecretKeySpec(key.getBytes(CHARSET), ALGORITHM);
        byte[] raw = k.getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return cipher.doFinal(data);

    }

    // public static void main(String[] args) throws Exception{
    // String str = "hello";
    // //String encryptedStr = encryptBase64(encrypt(str, key));
    //// String s= decrypt("J68kw8pL0vy0BX/+TpCoBg==", "12345");
    // String e = encrypt("Hello","1234512345123451");
    // System.out.println("encrypted string encryptedStr "+ e);
    // }

}
