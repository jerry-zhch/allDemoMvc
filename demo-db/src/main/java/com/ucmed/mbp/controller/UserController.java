package com.ucmed.mbp.controller;

import com.ucmed.mbp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhch
 * @since 2019-05-27
 */
@RestController
@RequestMapping("/demo-db/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "test.json")
    public Object userTest(){
        try {
            return userMapper.selectList(null);
        }catch (Exception e){
            return e;
        }
    }
}
