package com.example;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.ext.spring.ApplicationContextHolder;
import net.logstash.logback.appender.LogstashSocketAppender;

@Configuration
public class LogbackConfig {

	@Bean
	public static ApplicationContextHolder applicationContextHolder() {
		return new ApplicationContextHolder();
	}

	@Bean
	public static LoggerContext loggerContext() {
		return (LoggerContext) LoggerFactory.getILoggerFactory();
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public static LogstashSocketAppender logstashUdp(LoggerContext ctx) {
		LogstashSocketAppender appender = new LogstashSocketAppender();
		appender.setContext(ctx);
		appender.setHost("elk");
		appender.setPort(5514);
		return appender;
	}
}
