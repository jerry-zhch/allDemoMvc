package com.ucmed.mbp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ucmed.mbp.entity.User;
import com.ucmed.mbp.mapper.UserMapper;
import com.ucmed.mbp.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhch
 * @since 2019-05-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
