package org.eastwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eastwill.util.SignUtil;
import org.eastwill.util.message.MessageUtil;
import org.eastwill.util.message.TextMessageUtil;

public class WeixinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    System.out.println("MyServlet's doGet() method is invoked.");
	 // 微信加密签名
    	String signature = request.getParameter("signature");
    	// 时间戳
    	String timestamp = request.getParameter("timestamp");
    	// 随机数
    	String nonce = request.getParameter("nonce");
    	// 随机字符串
    	String echostr = request.getParameter("echostr");
    	if(signature==null)signature="";
    	if(timestamp==null)timestamp="";
    	if(nonce==null)nonce="";
    	if(echostr==null)echostr="";
    	if((signature.length()<1)&&(timestamp.length()<1)&&(nonce.length()<1)&&(echostr.length()<1)) {
    		return;
    	}
    	PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// 请求校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
    	if (SignUtil.checkSignature(signature, timestamp, nonce)) {
    		out.print(echostr);
    		System.out.println("返回响应结果"+echostr);
    	}
    	out.close();
    	out = null;  
	  }
	  @Override
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("MyServlet's doPost() method is invoked.");	
	    doAction(req, resp);
	  
	  }
	  
	  private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out = null;
		//将微信请求xml转为map格式，获取所需的参数
		Map<String,String> map = MessageUtil.xmlToMap(req);
		//遍历map
		//map.forEach((k,v)->{  
		//	log.info("使用java8循环 /key : " +k + " 值 : " + v);  
	    //});  
			
		String ToUserName = map.get("ToUserName");
		String FromUserName = map.get("FromUserName");
		String MsgType = map.get("MsgType");
	
//		HttpSession session = req.getSession(true);
//		session.setAttribute("gopenid",FromUserName);
//		resp.setHeader("topenid", FromUserName);
//		System.out.println("sessuin aaa1openid = "+session.getAttribute("aaa1openid"));
		String message = null;
		try {
			//response.sendRedirect("http://bbs.eastwill.org");
			System.out.println("--------------3 FromUserName="+FromUserName+" MsgType="+MsgType);
				
			out = resp.getWriter();
				
			//处理文本类型，实现输入1，回复相应的封装的内容
			if("text".equals(MsgType)){
				String Content = map.get("Content");
				System.out.println("Content="+Content);
				TextMessageUtil textMessage = new TextMessageUtil();
				message = textMessage.initMessage(FromUserName, ToUserName,Content);
				out.write(message);
				
			}else if("event".equals(MsgType)){
				//判断是否是自定义菜单点击事件
				String tEvent = map.get("Event");
				if(null==tEvent)tEvent="";
					
//					if("CLICK".equals(tEvent)) {
//						String tEventKey = map.get("EventKey");
//						log.info("tEventKey="+tEventKey);
//						//跳转到指定页面
//						turl = "/validate/"+tEventKey;
//						log.info("turl="+turl);
//						if("hosp_news".equals(tEventKey)) {
//							response.sendRedirect("http://bbs.eastwill.org");
//							return ;
//						}else if("health_wiki".equals(tEventKey)) {
//							//response.sendRedirect("http://www.eastwill.org");
//							response.setStatus(302);  
//							response.setHeader("location","http://www.eastwill.org");  
//							return;
//						}else {
//							response.sendRedirect("http://www.126.com");
//							return;
//						}
//				}
			}
			//--------
			}catch(Exception e) {
				System.out.println("1 "+e);
			}finally {
		        if(out != null){
		        	out.close();
		        }
			}
			
	  }


}
