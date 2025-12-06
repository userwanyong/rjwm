package cn.wanyj.rjwm.service.impl;

import cn.wanyj.rjwm.entity.OrderDetail;
import cn.wanyj.rjwm.mapper.OrderDetailMapper;
import cn.wanyj.rjwm.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}