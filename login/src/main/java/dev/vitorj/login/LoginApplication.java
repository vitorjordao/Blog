package dev.vitorj.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
public class LoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}

}
