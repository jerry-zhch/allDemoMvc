package com.ucmed.mbp.controller;

import com.ucmed.mbp.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhch
 * @since 2019-05-27
 */
@RestController
@Api("mybatis plus")
@RequestMapping("/demo-db/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "select user by id")
    @PostMapping(value = "/test.json")
    public Object userTest(
            @ApiParam(name = "id",value = "主键id") @RequestParam(value = "id") String id
    ){
        try {
            return userMapper.selectById(id);
        }catch (Exception e){
            return e;
        }
    }
}
