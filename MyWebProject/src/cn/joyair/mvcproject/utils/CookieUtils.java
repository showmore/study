package cn.joyair.mvcproject.utils;

import java.security.MessageDigest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	private static final String KEY = ":cookie@joyair.com123!";
	
	/**
	 * 让浏览器创建cookie文件的方法
	 * @param name
	 * @param req
	 * @param resp
	 * @param sec： 单位是秒
	 */
	
	public static void createCookie(String username, HttpServletRequest req, HttpServletResponse resp, int sec ) {
		Cookie userCookie = new Cookie("userkey", username);
		Cookie ssidCookie = new Cookie("ssid", md5Encrypt(username));
		userCookie.setMaxAge(sec);
		ssidCookie.setMaxAge(sec);
		resp.addCookie(userCookie);
		resp.addCookie(ssidCookie);
		
	}
	
	/**
	 * 对字符串加密
	 * @param string
	 * @return
	 */
	public static String md5Encrypt(String ss) {
		ss=ss==null?"":ss+KEY;
		char[] md5Digist = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'}; //十六进制字典
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); // md5 sha1 sha2
			byte[] ssarr = ss.getBytes();  //转为Bytes型数组
			md.update(ssarr); //把明文放入MessageDigest对象实例里去更新数据
			byte[] mssarr = md.digest(); //加密:  
			
			int len = mssarr.length;
			char[] str = new char[len*2];
			int k = 0;
			
			for(int i=0;i<len;i++) {
				byte b = mssarr[i]; //0101011
				str[k++] = md5Digist[b >>> 4 & 0xf ]; 	//位移并与运算
				str[k++] = md5Digist[b & 0xf ]; 
			}
			
			System.out.println(str);
			return new String(str);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
