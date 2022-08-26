package com.bob.bobhr.controller;

import com.bob.bobhr.entity.Bobmanage;
import com.bob.bobhr.entity.Result;
import com.bob.bobhr.service.IBobmanageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Timer;


@RestController
@RequestMapping("/select")
public class ManageController {

    @Autowired
    private IBobmanageService iBobmanageService;

    @PostMapping("/add")
    private Result<Bobmanage> add(String jobNumber, String name, int age, String sex) {
        Result res = new Result();
        Bobmanage bobmanage = new Bobmanage();
        bobmanage.setJobNumber(jobNumber);
        bobmanage.setName(name);
        bobmanage.setAge(age);
        bobmanage.setSex(sex);

        LocalDate now = LocalDate.now();
        bobmanage.setCreatTime(now);
        bobmanage.setLastEdit(now);
        try {
            if (iBobmanageService.save(bobmanage)) {
                res.setResultCode(200);
                res.setMessage("success");
            } else {
                res.setResultCode(400);
                res.setMessage("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage(e.toString());
            res.setResultCode(500);
        }
        return res;
    }

    @GetMapping("/list")
    private Result<Bobmanage> getList() {
        Result res = new Result();
        try {
            //获取所有数据
            List<Bobmanage> list = iBobmanageService.list(null);
            //成功,返回数据
            res.setData(list);
            res.setResultCode(200);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            //失败,返回错误信息
            res.setResultCode(400);
            return res;
        }
    }

    @DeleteMapping("/delete")
    private Result<Bobmanage> delete(String jobNumber) {
        Result res = new Result();
        Bobmanage bobmanage = new Bobmanage();
        bobmanage.setJobNumber(jobNumber);
        //

        try{
            if(iBobmanageService.removeById(bobmanage)){
            res.setMessage("success");
            res.setResultCode(200);}else{
                res.setMessage("fail");
                res.setResultCode(400);
            }

        } catch(Exception e){
            res.setMessage(e.toString());
            res.setResultCode(500);
        }
        ;
        return res;
    }

    @PostMapping("/update")
    private Result<Bobmanage> update(String jobNumber, String name, int age, String sex) {
        Result res = new Result();
        Bobmanage bobmanage = new Bobmanage();
        bobmanage.setJobNumber(jobNumber);
        bobmanage.setName(name);
        bobmanage.setAge(age);
        bobmanage.setSex(sex);
        LocalDate now = LocalDate.now();
        bobmanage.setLastEdit(now);
        //更新记录
        try {
            if (iBobmanageService.updateById(bobmanage)) {
                res.setResultCode(200);
                res.setMessage("success");
            }
        } catch (Exception e) {
            res.setMessage(e.toString());
            res.setResultCode(500);
        }
        return res;
    }


}

