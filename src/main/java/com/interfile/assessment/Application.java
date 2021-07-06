package com.interfile.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.EnumSet;
import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.interfile.assessment")
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.jsf");
	}

	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(
				EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}
}
