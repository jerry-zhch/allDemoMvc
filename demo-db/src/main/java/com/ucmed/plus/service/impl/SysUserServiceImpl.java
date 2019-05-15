package com.ucmed.plus.service.impl;

import com.ucmed.plus.entity.SysUser;
import com.ucmed.plus.mapper.SysUserMapper;
import com.ucmed.plus.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author zhch
 * @since 2019-05-14
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
