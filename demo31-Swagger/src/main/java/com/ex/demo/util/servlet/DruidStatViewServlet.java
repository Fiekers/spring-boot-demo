package com.ex.demo.util.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

/**
 *
 * @author wujing
 */
@WebServlet(urlPatterns = { "/druid/*" }, initParams = { @WebInitParam(name = "loginUsername", value = "demo"), @WebInitParam(name = "loginPassword", value = "demo") })
public class DruidStatViewServlet extends StatViewServlet {

	private static final long serialVersionUID = 1L;

}

