package com.gwolf.service;

import com.gwolf.microcloud.commons.config.FeignClientConfig;
import com.gwolf.service.fallback.IDeptClientServiceFallbackFactory;
import com.gwolf.vo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MICROCLOUD-ZUUL-GATEWAY",configuration = FeignClientConfig.class,
        fallbackFactory = IDeptClientServiceFallbackFactory.class)
public interface IDeptClientService {
    @RequestMapping(method = RequestMethod.GET,value = "/gwolf-proxy/dept-proxy/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);
    
    @RequestMapping(method = RequestMethod.GET,value = "/gwolf-proxy/dept-proxy/dept/list")
    public List<Dept> list();
    
    @RequestMapping(method = RequestMethod.POST,value = "/gwolf-proxy/dept-proxy/dept/add")
    public boolean add(Dept dept);
}
