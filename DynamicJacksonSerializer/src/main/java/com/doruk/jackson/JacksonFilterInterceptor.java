package com.mudo.jackson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContextAware;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class JacksonFilterInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		JacksonFilter filter = method.getMethodAnnotation(JacksonFilter.class);
		if (filter != null) {
			ApplicationContextAware.getBean(BeanPropertyJacksonFilter.class).updateContext(filter);
		} else {
			ApplicationBeanAware.getBean(BeanPropertyJacksonFilter.class).clearContext();
		}
		return super.preHandle(request, response, handler);
	}
}