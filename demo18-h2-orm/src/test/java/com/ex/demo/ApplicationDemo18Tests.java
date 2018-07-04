package com.ex.demo;

import com.ex.demo.bean.UserLog;
import com.ex.demo.dao.UserLogDao;
import com.ex.demo.service.UserService;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

// 需要创建好数据库，没有做自动创建的设置
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationDemo18Tests {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    /**
     * get请求
     */
    @Test
    public void getForObject() {
		/*UserLog bean = restTemplateBuilder.build().getForObject("http://localhost:8080/rest/update/{id}", UserLog.class, 1);
		System.out.println(bean);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 2);
		bean = restTemplateBuilder.build().postForObject("http://localhost:8080/rest/update", map, UserLog.class);
		System.out.println(bean);*/

        String result = restTemplateBuilder.additionalCustomizers(new ProxyCustomizer()).build().getForObject("http://www.demo.com", String.class);
        System.out.println(result);

    }

    static class ProxyCustomizer implements RestTemplateCustomizer {
        @Override
        public void customize(RestTemplate restTemplate) {
            String proxyHost = "43.255.104.179";
            int proxyPort = 8080;

            HttpHost proxy = new HttpHost(proxyHost, proxyPort);
            HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
                @Override
                public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
                    System.out.println(target.getHostName());
                    return super.determineProxy(target, request, context);
                }
            }).build();
            HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
            httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
            httpComponentsClientHttpRequestFactory.setReadTimeout(60000);
            restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
        }
    }

    @Autowired
	private UserLogDao userLogDao;

	@Test
	public void insert() {
		UserLog entity = new UserLog();
		entity.setUserName("无境");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		userLogDao.save(entity);
	}
	@Test
	public void delete() {
		userLogDao.delete(1);
	}
	@Test
	public void update() {
        UserLog entity = new UserLog();
		entity.setId(2);
		entity.setUserName("无境2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		userLogDao.save(entity);
	}
	@Test
	public void select() {
        UserLog result = userLogDao.findOne(2);
		System.out.println(result);
	}
	@Test
	public void select2() {
        UserLog result = userLogDao.findByUserName("无境2");
		System.out.println(result);
	}
	// 分页
	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Sort.Order(Sort.Direction.DESC, "id")));
		// Page<UserLog> result = userLogDao.findByUserName("无境2",
		// pageable);
		Page<UserLog> result = userLogDao.findAll(pageable);
		System.out.println(result.getContent());
	}
}
