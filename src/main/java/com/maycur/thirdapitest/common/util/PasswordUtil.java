package com.maycur.thirdapitest.common.util;

/**
 * Create by HuQiuYue on 2019-06-20
// */
//public class PasswordUtil {
//    /**
//     * 获取 password
//     */
//    public String generatePassword(String companyId, String key, String realName, String staffCode, String timestamp) {
//        String[] infos =
//                {companyId, StringUtils.isNotBlank(realName)? realName : "", staffCode, timestamp, key};
//        Arrays.sort(infos, String.CASE_INSENSITIVE_ORDER);
//
//        return encryptBySha1(String.format("%s%s%s%s%s", infos));
//    }
//
//
//    public String encryptBySha1(String plainText) {
//        String encryptedText = null;
//        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//
//        try {
//            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
//            mdTemp.update(plainText.getBytes("ISO-8859-1"));
//
//            byte[] md = mdTemp.digest();
//            int j = md.length;
//            char[] buf = new char[j * 2];
//            int k = 0;
//            for (int i = 0; i < j; i++) {
//                byte byte0 = md[i];
//                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
//                buf[k++] = hexDigits[byte0 & 0xf];
//            }
//            //加密结果
//            encryptedText = new String(buf);
//        } catch (Exception e) {
//           e.printStackTrace();
//        }
//        return encryptedText;
//    }
//}
