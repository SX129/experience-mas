package com.experience.mcp;

import com.experience.mcp.tools.weather.WeatherTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class MCPServer {
    public static void main(String[] args) {
        SpringApplication.run(MCPServer.class, args);
    }

    @Bean
    public ToolCallbackProvider weatherToolsCallbackProvider(WeatherTool weatherTool) {
        var weatherToolCallbackProvider = MethodToolCallbackProvider.builder()
                .toolObjects(weatherTool)
                .build();
        return weatherToolCallbackProvider;
    }
}
