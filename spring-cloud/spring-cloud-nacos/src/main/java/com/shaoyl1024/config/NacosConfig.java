package com.shaoyl1024.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "nacos")
public class NacosConfig {
    private String blackIpStr;
    private List<String> blackIpList;
    private Map<String, String> blackIpMap;
}
