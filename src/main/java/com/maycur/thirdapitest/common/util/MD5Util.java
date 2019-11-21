package com.maycur.thirdapitest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * Create by HuQiuYue on 2019-06-12
 */
public class MD5Util {

    public static final Logger logger = LoggerFactory.getLogger(DidiApiUtil.class);

    public static String string2MD5WithCharSet(String inStr, String charset) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            logger.error("Failed to initialize MD5 instance as {} ", e.toString());
            e.printStackTrace();
        }

        byte[] byteArray = new byte[0];

        try {
            byteArray = inStr.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return byte2HexString(md5.digest(byteArray));
    }

    private static String byte2HexString(byte[] md5Bytes) {
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
