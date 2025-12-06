package cn.wanyj.rjwm.service.impl;

import cn.wanyj.rjwm.entity.ShoppingCart;
import cn.wanyj.rjwm.mapper.ShoppingCartMapper;
import cn.wanyj.rjwm.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
