package com.bob.bobhr.controller;


import com.bob.bobhr.entity.Result;
import com.bob.bobhr.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2022-08-24
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class BobmanageController {

    @Autowired
    private ILoginService loginService;
    @RequestMapping("/login")
    public Result login( String name, String password){

        try {
            return loginService.Login(name,password);
        } catch (Exception e) {
            e.printStackTrace();
            Result res = new Result();
            res.setResultCode(500);
            res.setMessage(e.toString());
            return res;
        }
    }






}
