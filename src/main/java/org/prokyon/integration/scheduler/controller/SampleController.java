package org.prokyon.integration.scheduler.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }
}

