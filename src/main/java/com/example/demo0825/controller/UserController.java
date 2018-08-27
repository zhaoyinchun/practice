package com.example.demo0825.controller;

import com.example.demo0825.entity.User;
import com.example.demo0825.mapper.UserMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    public String test() {
        return "Success";
    }

    @RequestMapping("/getid")
    public String getid() {
        User data = userMapper.GetID(2);
        Gson gson = new Gson();
        String str = gson.toJson(data);
        return str + "\r" + "Success!";
    }

    @RequestMapping("/getname")
    public String getname() {
        User data = userMapper.GetName("小橙");
        Gson gson = new Gson();
        String str = gson.toJson(data);
        return str;
    }

    @RequestMapping("/getlist")
    public String getList() {
        List<User> data = userMapper.GetList();
        Gson gson = new Gson();
        String str = gson.toJson(data);
        return str + "\r" + "Success!";
    }

    @RequestMapping("/addUser")
    public String addUser() {
        User data = new User();
//        List<User> list = new ArrayList<User>();
        data.setName("小红");
        data.setAge(45);
        data.setPosition("啊啊啊");
//        list.add(data);
        userMapper.AddUser(data);
        return "success";
        /*
        页面显示错误，但数据库能正常添加数据
        */
        /*
        userMapper.AddUser("sfs",12,"sdfsad"); ???
        */
    }

    @RequestMapping("/update")
    public String updatetest() {
        int i = 2;
        userMapper.ReOrder(i);
        return "update students set XXX where id=" + i + " , success";
    }
        /*  Why!!!!!
        User data= userMapper.ReOrder(1);
        Gson gson=new Gson();
        String str=gson.toJson(data);
        return str;
        */
        /*
Mapper method 'com.example.demo0825.mapper.UserMapper.ReOrder' has an unsupported return type: class com.example.demo0825.entity.User
        */

    @RequestMapping("/delete")
    public String deltest() {
        int i = 1;
        userMapper.Del(i);
        return "delete from students where id=" + i + " , success";
    }

    /*
    @RequestMapping("/getuserapplyforsqlprovider")
    public String  getuserapplyforsqlprovider()
    {
        List<User> emplist= em.getuserapplyforsqlprovider();
        Gson gson=new Gson();
        String str=gson.toJson(emplist);
        return str;
    }
    */

}











