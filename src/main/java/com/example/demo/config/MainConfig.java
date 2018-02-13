package com.example.demo.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {
	@Bean
	public BasicDataSource dataSource() throws URISyntaxException {
		URI dbUri = new URI(System.getenv("postgres://pzxuggkofjfdqi:ec39e9cee9bf9724cade270c1ded96beef5eec3a6f7157de7d1c344cad90e19e@ec2-50-19-105-188.compute-1.amazonaws.com:5432/dc92ahv9l56kkh" ));
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(dbUrl);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);

		return basicDataSource;
	}
}
