package cn.lpctstr.node.data.util;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 18:00 2019/6/25
 * @Project: ZJSRTP
 */


import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class SHA256_Encoder {
    public static String generateSHA256(String orgStr){
        MessageDigest messageDigest;
        String result="";
        try {
            messageDigest=MessageDigest.getInstance("SHA-256");
            byte[] msg= messageDigest.digest(orgStr.getBytes(StandardCharsets.UTF_8));
            result= String.valueOf(Hex.encodeHex(msg));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

}