package com.shaoyl1024.componentsExplored.nacos203.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Data
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "nacos")
public class NacosDataTypeConfig {
    private String blackIpStr;
    private List<String> blackIpList;
    private Map<String, String> blackIpMap;
}
