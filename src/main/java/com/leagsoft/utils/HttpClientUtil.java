package com.leagsoft.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	
	public static CloseableHttpClient getHttpClient() {
		logger.info("Execute getHttpClient ");
		
		//设置超时
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(3000)
				.setSocketTimeout(30000)
				.build();
		
		return HttpClients.custom().setDefaultRequestConfig(config).build();					
	}
}
