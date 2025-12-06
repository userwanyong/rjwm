package cn.wanyj.rjwm.service.impl;

import cn.wanyj.rjwm.entity.User;
import cn.wanyj.rjwm.mapper.UserMapper;
import cn.wanyj.rjwm.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
