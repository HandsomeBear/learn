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

import com.leagsoft.utils.Constant;
import com.leagsoft.utils.HttpClientUtil;

public class ApproveResultTask implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(ApproveResultTask.class);
	
	@Override
	public void run() {
		logger.info("Execute task!");
		
		String url = "http://192.168.2.22/manager/sepolicy/commonExamineApproveController.htm?act=queryApprovalResult";
		HttpPost httpPost = new HttpPost(url);
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("method","outward_request_new"));
		params.add(new BasicNameValuePair("start","0"));
		params.add(new BasicNameValuePair("limit","20"));
		params.add(new BasicNameValuePair("sort","dttime"));
		params.add(new BasicNameValuePair("dir","desc"));
		params.add(new BasicNameValuePair("strusername",""));
		params.add(new BasicNameValuePair("params", "{\"operate\":\"aproval\",\"itype\":2,\"searchType\":\"\",\"searchValue\":\"\"}"));
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
		if(!result.contains("root")){
			result = "=====>"+result;
		}
		logger.info(result+"-->"+(Constant.count.incrementAndGet()));
	}

}
