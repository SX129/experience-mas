package com.experience.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MCPServer {
    public static void main(String[] args) {
        SpringApplication.run(MCPServer.class, args);
    }
}
