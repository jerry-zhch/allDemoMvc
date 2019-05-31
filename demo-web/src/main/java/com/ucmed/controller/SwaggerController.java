package com.ucmed.controller;

import com.juntaihc.www.ServiceStub;
import com.ucmed.mbg.mapper.HosListJiangganMapper;
import com.ucmed.mbg.model.HosListJianggan;
import com.ucmed.mbp.entity.User;
import com.ucmed.mbp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "测试")
@Controller
//@RequestMapping("/weixin")
@Slf4j
public class SwaggerController {

    @Autowired
    private IUserService userService;
    @Autowired
    private HosListJiangganMapper hosListJiangganMapper;
    @ApiOperation(value = "测试中文输入输出")
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET},value = "/swagger.do")
    @ResponseBody
    public JSONObject test2(
            @ApiParam(name = "name", value = "姓名") @RequestParam(value = "name",required = false) String name,
            @ApiParam(name = "phone", value = "电话") @RequestParam(value = "phone",required = false) String phone
    ){
        JSONObject res=new JSONObject();
        try {
            res.put("name","nnnn"+name);
            res.put("phone","ppp"+phone);
            User user=userService.getById(1);
            res.put("user",user);
        }catch (Exception e){
            log.info("====11111======"+e.getMessage());
            res.put("error",e.getMessage());
        }
        try {
            HosListJianggan hosListJianggan=hosListJiangganMapper.selectByPrimaryKey(2);
            res.put("hosList",hosListJianggan);
        }catch (Exception e){
            log.info("====22222222==="+e.getMessage());
            res.put("hosList",e.getMessage());
        }

        try {
            ServiceStub stub=new ServiceStub();
            ServiceStub.JTHC_Depts depts=new ServiceStub.JTHC_Depts();
            depts.setAUTH_KEY("sN70eYSNMIUDfPRT1wzpO");
            ServiceStub.JTHC_DeptsResponse deptsResponse=stub.jTHC_Depts(depts);
            JSONObject result=JSONObject.fromObject(deptsResponse.getJTHC_DeptsResult());
            res.put("webservice",result);
        }catch (Exception e){
            res.put("webservice",e.toString());
        }
        return res;
    }

}
