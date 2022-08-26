package com.bob.bobhr.service.impl;


import com.bob.bobhr.entity.Result;
import com.bob.bobhr.service.ILoginService;
import org.springframework.stereotype.Service;



@Service
public class LoginServiceImpl implements ILoginService {

    @Override
    public Result Login(String name, String password) {
        Result res = new Result();
        //
        if (name.equals("Admin") && password.equals("123456")) {
            res.setResultCode(200);
            res.setMessage("success");
            return res;
        } else {
            res.setResultCode(400);
            res.setMessage("fail");
            return res;

        }
    }
}
