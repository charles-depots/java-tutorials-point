package com.shaoyl1024.springboot.nacos203;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.shaoyl1024.springboot.nacos203.config.NacosDataTypeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

/**
 * @author charles.shao
 * @description Nacos 基本操作
 * @date 2023/3/4
 **/
@RestController
@RequestMapping("/nacos")
public class NacosConfigPrintController {

    @Autowired
    private NacosDataTypeConfig nacosDataTypeConfig;

    @Autowired
    private NacosConfigManager nacosConfigManager;

    private ConfigService configService;

    @PostConstruct
    public void init() {
        this.configService = nacosConfigManager.getConfigService();
    }

    /**
     * 打印基本数据类型 - list
     *
     * @return
     */
    @RequestMapping("/print/list")
    public String printList() {
        return nacosDataTypeConfig.getBlackIpList().toString();
    }

    /**
     * 发布更新Nacos配置
     *
     * @param dataId  配置 ID
     * @param group   配置分组
     * @param content 配置内容
     * @return
     * @throws NacosException
     */
    @PostMapping("/publishConfig")
    public Boolean publishConfig(@RequestParam(value = "dataId") String dataId,
                                 @RequestParam(value = "group") String group,
                                 @RequestParam(value = "content") String content,
                                 @RequestParam(value = "type") String type) throws NacosException {
        return configService.publishConfig(dataId, group, content, type);
    }

    /**
     * 打印Nacos配置
     *
     * @param dataId 配置 ID
     * @param group  配置分组
     * @return
     * @throws NacosException
     */
    @GetMapping("/getConfig")
    public String syncNacosConfig(@RequestParam(value = "dataId") String dataId,
                                  @RequestParam(value = "group") String group) throws NacosException {
        return configService.getConfig(dataId, group, 1000);
    }

}
