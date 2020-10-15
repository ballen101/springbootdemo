package com.example.demo.controller;

import com.example.demo.dao.userMapper;
import com.example.demo.dto.ResultVO;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class userController {

    @Autowired
    private userMapper userMapper;

    @GetMapping("/getUser")
    public ResultVO<List<User>> getUser() {
        List<User> userList = userMapper.findAll();
        return ResultVO.success(userList);
    }

    @GetMapping("/getUser/{id}")
    public ResultVO<User> getUser(@PathVariable long id){
        User user = userMapper.findById(id);
        if (user != null){
            return ResultVO.success(user);
        }
        return ResultVO.failed("查询不到该user");
    }


    @GetMapping("/getUsername")
    public ResultVO<List<User>> getUsername() {
        return ResultVO.success(userMapper.myQuery());
    }

//    @GetMapping("/index")
//    public String index(){
//        return "index";
//    }

    @GetMapping("/delete/{id}")
    public ResultVO delete(@PathVariable long id) {
        userMapper.deleteById(id);
        return ResultVO.success();

    }

    @PostMapping("/update")
    public ResultVO update(@RequestBody User user){
        User save = userMapper.saveAndFlush(user);
        if (save != null){
            return ResultVO.success();
        }
        return ResultVO.failed();
    }

    @PostMapping("/save")
    public ResultVO insert(@RequestBody User user){
        User save = userMapper.saveAndFlush(user);
        if (save != null){
            return ResultVO.success();
        }
        return ResultVO.failed();
    }
}
