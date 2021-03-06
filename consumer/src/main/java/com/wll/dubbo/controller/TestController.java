package com.wll.dubbo.controller;

import com.example.dubbointerface.dto.UserDto;
import com.wll.dubbo.service.impl.dubbo.ProviderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author wll
 * @Date 2019/10/16 13:32
 * @Description
 **/
@Controller
public class TestController {
    //public static final String masterUrl = "dubbo://127.0.0.1:20880";

    private static Logger logger = LogManager.getLogger(TestController.class);

    @Autowired
    private ProviderService providerService;

    @RequestMapping(value = "/master", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        String result = providerService.sayHello("wllpeter");
        return result;
    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUserById(Integer userId) {
        UserDto result = providerService.getUserById(userId);
        logger.info(result);
        return result;
    }
}
