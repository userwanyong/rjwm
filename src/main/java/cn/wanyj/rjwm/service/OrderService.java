package cn.wanyj.rjwm.service;

import cn.wanyj.rjwm.dto.OrderRequestDto;
import cn.wanyj.rjwm.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    void submit(Orders orders);

    void deliver(OrderRequestDto orderRequestDto);
}
