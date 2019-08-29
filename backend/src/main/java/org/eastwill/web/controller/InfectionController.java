package org.eastwill.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.eastwill.domain.AccessTokenHos;
import org.eastwill.domain.Menu;
import org.eastwill.domain.infection.CaseReport;
import org.eastwill.domain.router.VueRouter;
import org.eastwill.pojo.AdmReg;
import org.eastwill.pojo.HosparamIn;
import org.eastwill.pojo.HosparamOut;
import org.eastwill.service.AccessTokenHosService;
import org.eastwill.service.CaseReportService;
import org.eastwill.web.controller.system.TokenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/infection")
public class InfectionController {
	
	@Autowired
    private Environment env;
	@Autowired
	private AccessTokenHosService accessTokenHosService;
	@Autowired
	private TokenController tokenController;
	@Autowired
	private CaseReportService caseReportService;
	
	private String message;
	
	@GetMapping
    public String getAllAdmReg() {
		String tin = "20190301000000|20190302000000";
		String tdataOut = "";
		try {
			String toutstr = post_hisurl("searchalladmreg",tin+"|"); //传入空的商品交易号
			System.out.println("toutstr==>" + toutstr);
			HosparamOut thout = new HosparamOut();
			thout = JSON.parseObject(toutstr, HosparamOut.class);
			System.out.println("thout==>" + thout);
			String tresultCode = thout.getResultCode();
			String toutdata = thout.getOutdata().trim();
			String terrMsg = thout.getErrorMsg();
			if(tresultCode.equals("0")) {
				List<AdmReg> admRegList = new ArrayList<>();
				Object[] oArr = JSON.parseObject(toutdata, Object[].class);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				for (Object o : oArr) {
					AdmReg admReg = new AdmReg();
					Object[] oA = JSON.parseObject(o.toString(), Object[].class);
					String a = oA[1].toString();
					admReg.setSeq(Long.valueOf(oA[0].toString()));
					admReg.setPid(oA[1].toString());
					admReg.setPatientName(oA[2].toString());
					admReg.setGender(oA[3].toString());
					admReg.setAge(Integer.parseInt(oA[4].toString()));
					admReg.setAgeUnit(oA[5].toString());
					//admReg.setAdmissionDate(oA[6].toString());
					admReg.setAdmissionDate(sdf.format(new Date(Long.parseLong(oA[6].toString()))));
					//admReg.setAdmissionDate(Date.);
					admRegList.add(admReg);
				}
				Map<String, Object> rspData = new HashMap<>();
				rspData.put("rows", admRegList);
				rspData.put("total", 8);
				tdataOut = JSON.toJSONString(rspData);
				return tdataOut;
			}else {
				tdataOut = toutdata+"|"+tdataOut+terrMsg;
				tdataOut = "-12|查询失败"+toutdata+"|"+tdataOut;;
		    	return tdataOut;
			}
		}catch(Exception e){
			message = "查看医院人员";
			log.error(message,e);
			return "false";
		}
    }
	
	@PostMapping("/caseReport")
	public String saveCaseReport(CaseReport caseReport) {
		String seq = "";
		try {
			seq = caseReportService.saveCaseReport(caseReport);
		} catch (Exception e) {
			message = "新增caseReport";
			log.error(message,e);
			return "";
		}
		return seq;
	}
	
	
	public String post_hisurl(String thisurl,String tin) throws ClientProtocolException, IOException {
		String thosurl = env.getProperty("hosurl");
		String turl = thosurl+"/"+thisurl;
		String thoskey = env.getProperty("hoskey");
		HosparamIn thosparamIn = new HosparamIn();
		thosparamIn.setIndata(tin);
				
		String tsendstr = JSON.toJSONString(thosparamIn);
		String tout = "";
		log.info("post_hisurl tsendstr="+tsendstr +" turl="+turl);		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			AccessTokenHos taccessTokenHos = new AccessTokenHos();
			List<AccessTokenHos> tl_at = accessTokenHosService.searchAccessToken();
			for(AccessTokenHos tat : tl_at) {
				taccessTokenHos = tat;
			}
			Date tnow = new Date();
			String ttoken = "";
			if ((taccessTokenHos.getExpireTime().before(tnow))||(tl_at.size()<1)) {
				//cyrus
				//TokenController ttc = new TokenController();
				ttoken= tokenController.inithos(thoskey);
			}else {
				ttoken = taccessTokenHos.getAccessToken();
			}
			HttpPost httppost = new HttpPost(turl);
			httppost.setHeader("Accept","aplication/json");  	             
			httppost.addHeader("Content-Type","application/json;charset=UTF-8");  
			httppost.addHeader("token", ttoken);
			StringEntity s = new StringEntity(tsendstr,"UTF-8");
			s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));   
			s.setContentType("application/json");//发送json数据需要设置contentType
			httppost.setEntity(s);
			InputStream inputStream = null;

			CloseableHttpResponse response0 = httpclient.execute(httppost);
			try {
				HttpEntity resEntity = response0.getEntity();
			 	if (resEntity != null) {
			 		inputStream = resEntity.getContent();
			    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			      	String line = "";
			       	while ((line = bufferedReader.readLine()) != null) {
			       		tout = tout + line;
			        }
			       	log.info("post_hisurl  tout = "+tout);
			    }	          
			} finally {
				response0.close();
			}
		} finally {
			httpclient.close();
		}	
		return tout;
	}
}
