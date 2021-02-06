package io.tgroy1.configclientapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ConfigClientAppApplication {
	
	@Autowired
	private ConfigClientAppConfiguration configProp;
	
	@Value("${some.other.property}")
	private String someOtherProperty;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientAppApplication.class, args);
	}
	
	@RequestMapping
	private String printConfig() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(configProp.getProperty())
			.append(" || ")
			.append(someOtherProperty);
		
		return sb.toString();
	}
}
