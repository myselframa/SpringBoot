package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFIlter implements GlobalFilter{

	
	private Logger logger = LoggerFactory.getLogger(LoggingFIlter.class);
	
	
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("path of the request received->{}",exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
