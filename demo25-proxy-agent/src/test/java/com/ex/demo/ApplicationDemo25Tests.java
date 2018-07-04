package com.ex.demo;

import com.ex.demo.bean.UserLog;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

// 需要创建好数据库，没有做自动创建的设置
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDemo25Tests {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	/**
	 * get请求-暂时不能用，不知道啥情况不管了
	 src	 */
	@Test
	public void getForObject() {

		UserLog bean = restTemplateBuilder.build().getForObject("http://localhost:80/rest/update/{id}",
				UserLog.class, 1);
		System.out.println(bean);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 2);
		bean = restTemplateBuilder.build().postForObject("http://localhost:80/rest/update", map, UserLog.class);
		System.out.println(bean);

		String result = restTemplateBuilder.additionalCustomizers(new ProxyCustomizer()).build().getForObject("http://www.demo.com", String.class);
		System.out.println(result);

	}

	static class ProxyCustomizer implements RestTemplateCustomizer {
		@Override
		public void customize(RestTemplate restTemplate) {
			String proxyHost = "127.0.0.1";
			int proxyPort = 80;

			HttpHost proxy = new HttpHost(proxyHost, proxyPort);
			HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
				@Override
				public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context)
						throws HttpException {
					System.out.println(target.getHostName());
					return super.determineProxy(target, request, context);
				}
			}).build();
			HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
					httpClient);
			httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
			httpComponentsClientHttpRequestFactory.setReadTimeout(60000);
			restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
		}
	}
}
