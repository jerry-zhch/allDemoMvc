package com.ucmed.filter;

import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {

	private static final Logger logger = Logger.getLogger(LoginFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		try {
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
//			res.setHeader("Accept","application/json,"+req.getHeader("Accept"));

//			String path = httpServletRequest.getRequestURI();
//			path = path.toLowerCase();
//			// 忽略login.htm、静态js、css图片等
//			if (path.endsWith("/weixin/login.htm") || path.endsWith(".js")
//					|| path.endsWith("my97datepicker.html")
//					|| path.endsWith(".css") || path.endsWith(".jpg")
//					|| path.endsWith(".png") || path.endsWith(".bmp")
//					|| path.endsWith(".gif") || path.endsWith(".ico")
//					|| path.endsWith("/weixin/weixin.htm")
//					|| path.endsWith("/weixin/hospital.htm")
//					|| path.endsWith("/weixin/weiguan.htm")
//					|| path.endsWith("/weixin/newcenter.htm")
//					|| path.endsWith("/weixin/evaluationapp.htm")
//					|| path.endsWith("/weixin/forgetpassword.htm")
//					|| path.endsWith("/weixin/evaluation.htm")
//					|| path.endsWith("/weixin/userregist.htm")
//					|| path.endsWith("/weixin/floor.htm")) {
//				chain.doFilter(request, response);
//				return;
//			}
			chain.doFilter(request,response);
		} catch (Exception e) {
			logger.error(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

	private void go(PrintWriter pw, String url) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script type='text/javascript'>parent.parent.window.location.href='");
		sb.append(url);
		sb.append("';</script>");
		pw.println(sb);

		pw.flush();
		pw.close();
	}
}
