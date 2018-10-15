package com;

import java.io.File;
import java.io.IOException;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
@EnableTransactionManagement
public class MyApplication {
	// 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
	@Autowired
	private RestTemplateBuilder builder;

	// 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

	@Value("${https.port}")
	private Integer port;

	@Value("${https.ssl.key-store-password}")
	private String key_store_password;

	@Value("${https.ssl.key-password}")
	private String key_password;

	// 这是spring boot 2.0.X版本的 添加这个，上一个就不用添加了
	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(createSslConnector()); // 添加http
		return tomcat;
	}

	/*
	// 这是spring boot 1.5.X以下版本的 添加了这个
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addAdditionalTomcatConnectors(createSslConnector()); // 添加http
        return tomcat;
    }
    */
	
	// 配置https

	private Connector createSslConnector() {
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
		try {
			File keystore = new ClassPathResource("server.keystore").getFile();
			/* File truststore = new ClassPathResource("sample.jks").getFile(); */
			connector.setScheme("https");
			connector.setSecure(true);
			connector.setPort(port);
			protocol.setSSLEnabled(true);
			protocol.setKeystoreFile(keystore.getAbsolutePath());
			protocol.setKeystorePass(key_store_password);
			protocol.setKeyPass(key_password);
			return connector;
		} catch (IOException ex) {
			throw new IllegalStateException(
					"can't access keystore: [" + "keystore" + "] or truststore: [" + "keystore" + "]", ex);
		}
	}
}
