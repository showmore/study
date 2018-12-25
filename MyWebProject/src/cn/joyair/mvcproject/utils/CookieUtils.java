package cn.joyair.mvcproject.utils;

import java.security.MessageDigest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	private static final String KEY = ":cookie@joyair.com123!";
	
	/**
	 * �����������cookie�ļ��ķ���
	 * @param name
	 * @param req
	 * @param resp
	 * @param sec�� ��λ����
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
	 * ���ַ�������
	 * @param string
	 * @return
	 */
	public static String md5Encrypt(String ss) {
		ss=ss==null?"":ss+KEY;
		char[] md5Digist = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'}; //ʮ�������ֵ�
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); // md5 sha1 sha2
			byte[] ssarr = ss.getBytes();  //תΪBytes������
			md.update(ssarr); //�����ķ���MessageDigest����ʵ����ȥ��������
			byte[] mssarr = md.digest(); //����:  
			
			int len = mssarr.length;
			char[] str = new char[len*2];
			int k = 0;
			
			for(int i=0;i<len;i++) {
				byte b = mssarr[i]; //0101011
				str[k++] = md5Digist[b >>> 4 & 0xf ]; 	//λ�Ʋ�������
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
