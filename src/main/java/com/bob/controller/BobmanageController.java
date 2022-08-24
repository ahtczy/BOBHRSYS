package com.bob.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2022-08-24
 */
@Controller
public class BobmanageController {
    @RequestMapping("/*")
    public String index() {
        return "index";
    }
}
