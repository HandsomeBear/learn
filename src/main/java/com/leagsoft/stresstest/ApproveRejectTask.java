package com.leagsoft.stresstest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leagsoft.domain.ApproveRejectRecord;
import com.leagsoft.utils.HttpClientUtil;

public class ApproveRejectTask implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(ApproveRejectTask.class);
	
	@Override
	public void run(){
		logger.info("Execute task!");
		
		String url = "http://192.168.2.22/manager/sepolicy/commonExamineApproveController.htm?act=approveRejectRecord";
		HttpPost httpPost = new HttpPost(url);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("method","outward_request_new"));
		params.add(new BasicNameValuePair("uidapplyid","3AAF623B-617F-497E-8C29-05F4C964A396"));
		params.add(new BasicNameValuePair("records",getRecords()));//map的json字符串
		params.add(new BasicNameValuePair("operateval","0"));//0-拒绝；1-通过
		params.add(new BasicNameValuePair("onlyApproveReject","onlyApproveReject"));//写死
		params.add(new BasicNameValuePair("strwatermarkname",""));//水印方案名称
		UrlEncodedFormEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(params, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			logger.error("UnsupportedEncodingException Occur", e1);
		}
		httpPost.setEntity(entity);
		httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
		
		CloseableHttpResponse response;
		BufferedReader reader = null;
		CloseableHttpClient client = HttpClientUtil.getHttpClient();
		StringBuffer sb = new StringBuffer();  
		try {
			response = client.execute(httpPost);
			String reponseCode = response.getStatusLine().toString().trim();
			if(reponseCode.contains("200")){
				HttpEntity respEntity = response.getEntity();
				if(respEntity != null){
					reader = new BufferedReader(new InputStreamReader(respEntity  
                            .getContent(), "UTF-8"));  
                    String line = null;  
                    while ((line = reader.readLine()) != null) {  
                        sb.append(line);  
                    }
				}
				EntityUtils.consume(respEntity);
			}
			
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException Occur", e);
		} catch (IOException e) {
			logger.error("IOException Occur", e);
		}finally{
			try {
				if(reader != null){
					reader.close();
				}
				client.close();
			} catch (IOException e) {
				logger.error("Close Source Occur", e);
			}
		}
		String result = sb.toString();
		if(!result.contains("success")){
			result = "=====>"+result;
		}
		logger.info(result);
	}
	
	private String getRecords(){
		ApproveRejectRecord record = new ApproveRejectRecord();
		record.setUidapplyid("3AAF623B-617F-497E-8C29-05F4C964A396");
		record.setIsubtype("0");
		record.setStrsubtype("");
		record.setItype("5");
		record.setIinfo1("0");
		record.setIinfo2("0");
		record.setIinfo3("0");
		record.setStrinfo1("F:\\资料\\线程池原理及创建(C++实现).pdf");
		record.setStrinfo2("C:\\线程池原理及创建(C++实现).pdf");
		record.setStrinfo3("");
		
		List<ApproveRejectRecord> records = new ArrayList<ApproveRejectRecord>();
		records.add(record);
		
		ObjectMapper mapper = new ObjectMapper();
		String s = "";
		try{
			s = mapper.writeValueAsString(records);
		}catch(Exception e){
			logger.error("WriteAsString Error", e);
		}
		return s;
	}
}
