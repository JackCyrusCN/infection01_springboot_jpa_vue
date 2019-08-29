package org.eastwill.wx;

import java.text.SimpleDateFormat;
import java.util.Date;

//import org.eastwill.wx.pojo.HosparamOut;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestJsonC {
/*
	public static void main(String[] args) {
		//String str = "{\"errorMsg\":\"nnnn\",\"outdata\":\" 000000579223\",\"resultCode\":\"0a\"}";
		//HosparamOut tout = JSON.parseObject(str, HosparamOut.class);;
		//System.out.println("tout="+tout.getErrorMsg());
		String tregrange = "2018-06-12";
		tregrange = tregrange.substring(0, 4)+tregrange.substring(5,7)+tregrange.substring(8,10)+"000000";
		System.out.println("tout="+tregrange);
	}
*/
/*//	public static void main(String[] args) {
//		long dateTime = 14830682769461L;
//		Date date = new Date(dateTime);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sdf.format(date));
//		date = new Date(-24);
//		System.out.println(date);
//		System.out.println(dateTime);
//	}
 */ 
	/*public static void main(String[] args) { 
		String content ="result=0&faillist=&balance=18&linkid=4F7DDE3557374894B7A2B056D5CD1FEE&description=发送短信成功"; 
		content = content.replace("=","\":\""); 
		System.out.println(content); 
		content = content.replace("&","\",\""); 
		System.out.println(content); 
		content = "{\"" + content +"\"}"; 
		System.out.println(content); 
		JSONObject object = JSON.parseObject(content); 
		
		System.out.println(object.toJSONString()); 
		System.out.println(object.get("linkid"));
		}*/
		

}
