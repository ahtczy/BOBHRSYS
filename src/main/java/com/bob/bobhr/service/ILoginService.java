package com.bob.bobhr.service;


import com.bob.bobhr.entity.Result;

public interface ILoginService {

    Result Login(String name, String password);

}
