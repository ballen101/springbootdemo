package com.example.demo.controller;

import com.example.demo.dao.applyMapper;
import com.example.demo.dto.ResultVO;
import com.example.demo.entity.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by 星 on 2020/8/25
 */
@RestController
@RequestMapping("apply")
public class applyController {

    @Autowired
    private applyMapper applyMapper;

    @GetMapping("/list")
    public ResultVO list(){
        return ResultVO.success(applyMapper.findAll());
    }

    @PostMapping("/save")
    public ResultVO insert(@RequestBody Apply apply){
        apply.setTaskId(UUID.randomUUID().toString());
        Apply save = applyMapper.save(apply);
        if (save !=null){
            return ResultVO.success();
        }
        return ResultVO.failed();
    }
}
