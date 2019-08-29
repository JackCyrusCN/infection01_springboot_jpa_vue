package org.eastwill.web.controller.system;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.eastwill.domain.AccessToken;
import org.eastwill.domain.AccessTokenHos;
import org.eastwill.domain.DictHsp;
import org.eastwill.service.AccessTokenHosService;
import org.eastwill.service.AccessTokenService;
import org.eastwill.service.DictHspService;
import org.eastwill.service.TokenService;
import org.eastwill.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPayUtil;

@Controller
public class TokenController {
	private static Logger log = LoggerFactory.getLogger(TokenController.class);
	@Autowired
    private Environment env;
	@Autowired
	private AccessTokenService accessTokenService;
	@Autowired
	private AccessTokenHosService accessTokenHosService;
	@Autowired
	private DictHspService dictHspService;
	@Autowired
	private TokenService tokenService;
	
	//获取已经存在的token，如果过期返回''
	/*@GetMapping("/api/v1/gettoken")
	public String gettoken(HttpSession session,HttpServletResponse response) {
		//log.info("/api/v1/gettoken");
		AccessToken ttoken = new AccessToken();
		List<AccessToken> tl_token =  accessTokenService.searchAccessToken();
		for(AccessToken t:tl_token) {
			ttoken = t;
		}
		Date texpire_time = ttoken.getExpireTime();
		if(texpire_time.compareTo(new Date())<=0) {
			//获取新的token,更新本地数据库
			String tappID = env.getProperty("appID");
			String tAppSecret = env.getProperty("AppSecret");
			String tt = getnewToken(tappID,tAppSecret);
			ttoken.setAccessToken(tt);			
		}
				
		log.info("0000000000000000000 header  topenid="+response.getHeader("topenid"));
		String topenid = (String) session.getAttribute("gopenid");
		log.info("11111111111111111111 gettoken FromUserName="+topenid );
		//if ((topenid==null)||(topenid.length()<1)) {
//		try {
//			String tburl = env.getProperty("tokenurl");
//			log.info("tburl="+tburl);
//			getopenid(response);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			log.info("获取openid错误"+e);
//		}
		
		String tl_newsJson = JSON.toJSONString(ttoken);
		tl_newsJson = "{\"success\":true,\"data\":"+tl_newsJson+"}";
		//log.info("tl_newsJson="+tl_newsJson);
		return tl_newsJson;
	}*/
	//更新获取到的token
	@PostMapping("/api/v1/updtoken")
	public ResponseEntity<Object> updtoken(@RequestBody AccessToken tokens) {
		accessTokenService.delToken();
		AccessToken savedToken = accessTokenService.saveToken(tokens);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedToken.getAccessToken())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	//回调返回openid
/*	@RequestMapping(value = "/eastwillcallback")
	public void eastwillcallback(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("code");
		String tstate = request.getParameter("state");
		String tappid = env.getProperty("appID");
		String tappsecret = env.getProperty("AppSecret");
		String redirectUrl = acquireOpenIDUrlWithCode(code,tappid,tappsecret);
		
		log.info("33333 tstate="+tstate+" eastwillcallback  tcode="+code+" 1redirectUrl is : {}", redirectUrl);
		String responseText = HttpClientUtil.doGet(redirectUrl);
		//log.info("1responseText is : {}", redirectUrl, responseText);
		JSONObject jsonObject = JSONObject.parseObject(responseText);  
	    // JsonAccessToken tJsonAccessToken = (JsonAccessToken) JSON.parse(result);
	    String topenid = (String) jsonObject.get("openid");  
	    String taccess_token = (String) jsonObject.get("access_token");
	    log.info("openid="+topenid);
	    //log.info("taccess_token="+taccess_token);
			 
	    redirectUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+taccess_token+"&openid="+topenid+"&lang=zh_CN";
	    responseText = HttpClientUtil.doGet(redirectUrl);
	    JSONObject jsonObject1 = JSONObject.parseObject(responseText);  

	    String tnickname = (String) jsonObject1.get("nickname");
	    Integer tsex = (Integer) jsonObject1.get("sex"); 
	    String tprovince = (String) jsonObject1.get("province"); 
	    String tcity = (String) jsonObject1.get("city"); 
	    String tcountry = (String) jsonObject1.get("country"); 
	        
	    JSONArray tprivilege_array = jsonObject1.getJSONArray("privilege");
	    String tprivilege = "";
	    if(null !=tprivilege_array) {
	    	tprivilege_array.toJSONString();
	    }
	    String tunionid = (String) jsonObject1.get("unionid"); 
	    log.info("tnickname="+tnickname+"  tsex="+tsex+" tprovince="+tprovince+" tcity="+tcity+" tcountry="+tcountry);
	    WxUser tWxUser = new WxUser();
	    tWxUser.setOpenid(topenid);
	    tWxUser.setNickname(tnickname);
	    tWxUser.setSex(tsex);
	    tWxUser.setProvince(tprovince);
	    tWxUser.setCity(tcity);
	    tWxUser.setCountry(tcountry);
	    tWxUser.setPrivilege(tprivilege);
	    tWxUser.setUnionid(tunionid);
	    tWxUser.setCreateTime(new Date());
	    tWxUser.setUpdTime(new Date());
	    try {
	    	wxUserService.SaveWxUser(tWxUser);
	    }catch(Exception e) {
	    	log.error(""+e);
	    }
		 	
	    String tmainurl = env.getProperty("mainurl");
		String turl = tmainurl+"/pcenter?openid="+topenid;
		if(tstate.equals("pcenter")) {  //个人中心
			turl = tmainurl+"/pcenter?openid="+topenid;
		}else if(tstate.equals("regorder")) { //预约挂号
			turl = tmainurl+"/regorder?openid="+topenid;
		}else if(tstate.equals("feeout")) {  //门诊缴费
			turl = tmainurl+"/feeout?openid="+topenid;
		}else if(tstate.equals("feein")) {  //住院缴费
			turl = tmainurl+"/feein?openid="+topenid;
		}else if(tstate.equals("navhos")) {  //来院导航
			turl = tmainurl+"/navhos?openid="+topenid;
		}else if(tstate.equals("hosintrod")) {  //医院简介
			turl = tmainurl+"/hosintrod?openid="+topenid;
		}else if(tstate.equals("dept")) {  //科室介绍
			turl = tmainurl+"/dept?openid="+topenid;
		}else if(tstate.equals("phy")) {  //本院名医
			turl = tmainurl+"/phy?openid="+topenid;
		}else if(tstate.equals("instrument")) {  //先进设备
			turl = tmainurl+"/instrument?openid="+topenid;		
		}else if(tstate.equals("news")) {  //医院新闻
			turl = tmainurl+"/news?openid="+topenid;
		}else if(tstate.equals("health")) {  //健康百科
			turl = tmainurl+"/health?openid="+topenid;
		}else if(tstate.equals("talk")) { //说你说我
			turl = tmainurl+"/talk?openid="+topenid;
		}
		log.info("eastwillcallback turl="+turl);
		response.sendRedirect(turl); 
	  
	}	
		
	private String acquireOpenIDUrlWithCode(String code,String tappid,String tappsecret) {
		StringBuilder sb = new StringBuilder();
		sb.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+tappid+"&"
			+ "secret="+tappsecret+"&code="
			+ code
			+ "&grant_type=authorization_code");
		return sb.toString();
	}			

	private String getnewToken(String tappid,String tappsecret) {
		String token = "";
		String charset="utf-8";
		String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+tappid+"&secret="+tappsecret;
			
		HttpClient httpClient = null;  
	    HttpGet httpGet= null;  
	    String result = null;  
	          
	    try {  
	    	httpClient = new SSLClient();  
	        httpGet = new HttpGet(url);  
	              
	        HttpResponse response = httpClient.execute(httpGet);  
	        if(response != null){  
	        	HttpEntity resEntity = response.getEntity();  
	            if(resEntity != null){  
	            	result = EntityUtils.toString(resEntity,charset);  
	            }  
	        }  
	        JSONObject jsonObject = JSONObject.parseObject(result);  
	        // JsonAccessToken tJsonAccessToken = (JsonAccessToken) JSON.parse(result);
	        String  j_access_token = (String) jsonObject.get("access_token");  
	        Integer tj_expires_in = (Integer) jsonObject.get("expires_in");
	        AccessToken tAccessToken = new AccessToken();
	        tAccessToken.setAccessToken(j_access_token);
	        tAccessToken.setExpiresIn(Integer.valueOf(tj_expires_in));
	        Date tcreateTime = new Date();
	        Date texpireTime = addOneSecond(tcreateTime, tj_expires_in-10);
	        tAccessToken.setCreateTime(tcreateTime);
	        tAccessToken.setExpireTime(texpireTime);
	        token = j_access_token;
	        try {
	        	accessTokenService.delToken();
	        	accessTokenService.saveToken(tAccessToken);
	        }catch(Exception e) {
	        	log.error(""+e);
	        }
	        
	   } catch (Exception e) {  
		   e.printStackTrace();  
	   }  
	    return token;
	}
	
	
	@GetMapping("/api/v1/getopenid")
	private void getopenid(HttpServletResponse response) throws IOException {
		log.info("-1-1-1-1-1-1-1-1-1  "+response.getHeader("topenid"));
		String turl0 = env.getProperty("tokenurl");
		String tredirect_uri = URLEncoder.encode(turl0,"UTF-8");
		//String tscope = "snsapi_base";
		String tscope = "snsapi_base";
		String tappID = env.getProperty("appID");
		//tAppSecret = env.getProperty("AppSecret");
		String tstate = "eastwill";
		//log.info("login-----------------------tscope="+tscope);
		String turl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+tappID+"&redirect_uri="+tredirect_uri+"&response_type=code&scope="+tscope+"&state="+tstate+"#wechat_redirect";
		//turl = "http://mp.weixin.qq.com/mp/redirect?"+turl;
		log.info("getopenid turl="+turl);
		
		response.sendRedirect(turl);
		
	}	
	//获取公众号基本信息
	@RequestMapping(value = "/api/v1/getcustomer", method = RequestMethod.GET)
	@ResponseBody
	private String getcustomer()  {
		String tappid = env.getProperty("appID");
		String tappsecret = env.getProperty("AppSecret");
		String ttokenurl = env.getProperty("tokenurl");
		String tmainurl = env.getProperty("mainurl"); 
		String tJson = "{\"appid\":\""+tappid+"\",\"appsecret\":\""+tappsecret+"\",\"tokenurl\":\""+ttokenurl+"\",\"mainurl\":\""+tmainurl+"\"}";
		String tnewsJson = "{\"success\":true,\"data\":"+tJson+"}";
		return tnewsJson;
	}
	//微信jssdk接口config生成签名
	@GetMapping("/api/v1/jssdksigns/{tinurl}")
	@ResponseBody
	public String jssdksign(@PathVariable String tinurl) throws Exception {
		//获取token
		String ttokenid = "";
		String tappID = env.getProperty("appID");
		String tAppSecret = env.getProperty("AppSecret");
		String tmainurl = env.getProperty("mainurl");
		AccessToken ttoken = new AccessToken();
		List<AccessToken> tl_token =  accessTokenService.searchAccessToken();
		for(AccessToken t:tl_token) {
			ttoken = t;
			ttokenid = t.getAccessToken();
		}
		Date texpire_time = ttoken.getExpireTime();
		if(texpire_time.compareTo(new Date())<=0) {
			//获取新的token,更新本地数据库			
			ttokenid = getnewToken(tappID,tAppSecret);
			ttoken.setAccessToken(ttokenid);	
		}
		String turl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+ttokenid+"&type=jsapi";
		HttpClient httpClient = null;  
	    HttpGet httpGet= null;  
	    String result = null; 
	    String charset="utf-8";
	    String  j_ticket = "";
	    try {  
	    	httpClient = new SSLClient();  
	        httpGet = new HttpGet(turl);  
	              
	        HttpResponse response = httpClient.execute(httpGet);  
	        if(response != null){  
	        	HttpEntity resEntity = response.getEntity();  
	            if(resEntity != null){  
	            	result = EntityUtils.toString(resEntity,charset);  
	            }  
	        }  
	        JSONObject jsonObject = JSONObject.parseObject(result);  
	        j_ticket = (String) jsonObject.get("ticket");  
	        //Integer tj_expires_in = (Integer) jsonObject.get("expires_in");	       	        
	   } catch (Exception e) {  
		   e.printStackTrace();  
	   }  
	    //签名生成规则如下：参与签名的字段包括noncestr（随机字符串）, 有效的jsapi_ticket, timestamp（时间戳）, url（当前网页的URL，不包含#及其后面部分） 。
	    
		//wx.config({
		//    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		//    appId: '', // 必填，公众号的唯一标识
		//    timestamp: , // 必填，生成签名的时间戳
		//    nonceStr: '', // 必填，生成签名的随机串
		//    signature: '',// 必填，签名
		//    jsApiList: [] // 必填，需要使用的JS接口列表
		//});

        //将前端需要用的字段进行加密校验，并返回   
		Payweixinconfig config = new Payweixinconfig();
        Map<String, String> data_out = new HashMap<String, String>();
        //String tappId="wx642ba4d5d5b1c231";    //公众号名称，由商户传入     
        String ttimeStamp = Long.toString(System.currentTimeMillis() / 1000); //时间戳，自1970年以来的秒数     
        String tnonceStr = WXPayUtil.generateNonceStr(); //随机字符串 
        //String tsignTyp="MD5";         //微信签名方式：     
        data_out.put("nonceStr", tnonceStr);
        data_out.put("jsapi_ticket", j_ticket);
        data_out.put("timeStamp", ttimeStamp);      
        tinurl = tmainurl+"/"+tinurl;
        data_out.put("url", tinurl);
       // log.info("tinurl="+tinurl);
        //String tsignature = WXPayUtil.generateSignature(data_out, config.getKey()); //微信签名
       // log.info("tsignature="+tsignature);
        //data_out.put("signature", tsignature);
        data_out.put("appId", tappID);
        
        Map map = new HashMap();
        map.put("noncestr", tnonceStr);
        map.put("jsapi_ticket", j_ticket);
        map.put("timestamp", ttimeStamp);
        map.put("url", tinurl);
        String[] ss = {"noncestr", "jsapi_ticket", "timestamp", "url"};
        Arrays.sort(ss);
        String signStr = "";
        for (String s : ss) {
            signStr += s + "=" + map.get(s) + "&";
        }
        signStr = signStr.substring(0, signStr.length() - 1);
        signStr = SHA1.encode(signStr);
        log.info("signStr="+signStr);
        data_out.put("signature", signStr);
        
        String tl_newsJson = JSON.toJSONString(data_out);
		tl_newsJson = "{\"success\":true,\"data\":"+tl_newsJson+"}";
		log.info("返回前台tl_newsJson="+tl_newsJson);
		return tl_newsJson;		
	}

	//dll端登录初始化
    @GetMapping("/api/v1/initweixin/{thoskey}")
    public @ResponseBody String initweixin(@PathVariable String thoskey){
        //JSONObject jsonObject=new JSONObject();
        //String thoskey = tdistHsp.getHosKey();
        DictHsp userForBase=dictHspService.searchByHoskey(thoskey);
        if(userForBase==null){
            //jsonObject.put("message","登录失败,医疗机构不存在");
            //return jsonObject;
        	return "微信初始化失败,医疗机构不存在";
        }else {
            if (!userForBase.getHosKey().equals(thoskey)){
                //jsonObject.put("message","登录失败,密码错误");
                //return jsonObject;
            	return "微信初始化失败,授权码错误";
            }else {
                String token = tokenService.getToken(userForBase);
             
                log.info("dll token="+token);
                return token;
            }
        }
    }*/
    
    //登录医院his服务函数
    public String inithos(String thoskey){
        DictHsp userForBase=dictHspService.searchByHoskey(thoskey);
        if(userForBase==null){
        	return "微信初始化连接his失败,医疗机构不存在";
        }else {
            if (!userForBase.getHosKey().equals(thoskey)){
            	return "微信初始化连接his失败,授权码错误";
            }else {
                String token = tokenService.getToken(userForBase);
                accessTokenHosService.delToken();
                AccessTokenHos taccessTokenHos = new AccessTokenHos();
                taccessTokenHos.setAccessToken(token);
                taccessTokenHos.setCreateTime(new Date());
                taccessTokenHos.setExpiresIn(86400);
                taccessTokenHos.setExpireTime(addOneSecond(new Date(),86400));
                accessTokenHosService.saveToken(taccessTokenHos);
                log.info("hos token="+token);
                return token;
            }
        }
    }
    
    public Date addOneSecond(Date date,int tsecond_num) {    
		Calendar calendar = Calendar.getInstance();    
	    calendar.setTime(date);    
	    calendar.add(Calendar.SECOND, tsecond_num);    
	    return calendar.getTime();    
	}  
}
