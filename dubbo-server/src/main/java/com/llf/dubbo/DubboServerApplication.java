package com.llf.dubbo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DubboServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DubboServerApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}

}

