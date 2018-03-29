package com.springtest.SpringRest.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UtilityRestController {

    private ApplicationContext appContext;

    public UtilityRestController(ApplicationContext appContext) {
        this.appContext = appContext;
    }

    @RequestMapping("/beans")
    public Map<String, String[]> beans(@RequestParam(required = false) String q) {
        Map<String, String[]> retMap = new HashMap<>();
        String[] retArray = Arrays.stream(appContext.getBeanDefinitionNames())
                .filter(beanName ->
                        (q == null || q.length() == 0) ||
                                beanName.toLowerCase().contains(q.trim().toLowerCase())
                )
                .toArray(String[]::new);
        retMap.put("beans", retArray);
        return retMap;
    }
}
