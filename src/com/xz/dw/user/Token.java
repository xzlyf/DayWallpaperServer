package com.xz.dw.user;

import java.security.MessageDigest;

public class Token {
	public static String getToken(String id,String psw){
		return getMD5(id+psw+"0FdSk5");
	}
	
	 private static String getMD5(String st) {
	        try {

	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] array = md.digest(st.getBytes("UTF-8"));
	            StringBuilder sb = new StringBuilder();

	            for (byte item : array) {

	                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));

	            }
	            System.out.println("MD5值(测试用):"+sb.toString().toLowerCase());
	            return sb.toString().toLowerCase();

	        }catch (Exception e){
	            return null;
	        }
	    }
}
