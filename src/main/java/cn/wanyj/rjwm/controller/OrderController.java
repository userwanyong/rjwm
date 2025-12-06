package cn.wanyj.rjwm.controller;

import cn.wanyj.rjwm.common.BaseContext;
import cn.wanyj.rjwm.common.R;
import cn.wanyj.rjwm.dto.OrderRequestDto;
import cn.wanyj.rjwm.dto.OrderResponseDto;
import cn.wanyj.rjwm.entity.OrderDetail;
import cn.wanyj.rjwm.entity.Orders;
import cn.wanyj.rjwm.service.OrderDetailService;
import cn.wanyj.rjwm.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Resource
    private OrderDetailService orderDetailService;

    /**
     * 用户下单
     *
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        log.info("订单数据：{}", orders);
        orderService.submit(orders);
        return R.success("下单成功");
    }

    /**
     * 订单分页查询
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String number, String beginTime, String endTime) {
        log.info("分页查询，页码：{}，页大小：{}", page, pageSize);
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(number != null, Orders::getNumber, number);
        queryWrapper.between(beginTime != null && endTime != null, Orders::getOrderTime, beginTime, endTime);
        Page<Orders> ordersPage = orderService.page(new Page<>(page, pageSize), queryWrapper);
        Page<OrderResponseDto> res = new Page<>();
        BeanUtils.copyProperties(ordersPage, res, "records");
        List<Orders> records = ordersPage.getRecords();
        List<OrderResponseDto> list = records.stream().map((item) -> {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            BeanUtils.copyProperties(item, orderResponseDto);
            orderResponseDto.setAddress(item.getAddress());
            orderResponseDto.setPhone(item.getPhone());
            orderResponseDto.setConsignee(item.getConsignee());
            orderResponseDto.setUserName(item.getUserName());
            //根据订单id查询订单详情
            Long orderId = item.getId();
            List<OrderDetail> orderDetailList = orderDetailService.list(new LambdaQueryWrapper<OrderDetail>().eq(OrderDetail::getOrderId, orderId));
            orderResponseDto.setOrderDetails(orderDetailList);
            return orderResponseDto;
        }).collect(Collectors.toList());
        res.setRecords(list);
        return R.success(res);
    }

    /**
     * 派送
     */
    @PutMapping
    public R<String> deliver(@RequestBody OrderRequestDto orderRequestDto) {
        log.info("订单数据：{}", orderRequestDto);
        orderService.deliver(orderRequestDto);
        return R.success("派送成功");
    }

    /**
     * http://localhost:8080/order/userPage?page=1&pageSize=1
     */
    @GetMapping("/userPage")
    public R<Page> userPage(int page, int pageSize) {
        log.info("分页查询，页码：{}，页大小：{}", page, pageSize);
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq( Orders::getUserId, BaseContext.getCurrentId());
        Page<Orders> ordersPage = orderService.page(new Page<>(page, pageSize), queryWrapper);
        Page<OrderResponseDto> res = new Page<>();
        BeanUtils.copyProperties(ordersPage, res, "records");
        List<Orders> records = ordersPage.getRecords();
        List<OrderResponseDto> list = records.stream().map((item) -> {
            OrderResponseDto orderResponseDto = new OrderResponseDto();
            BeanUtils.copyProperties(item, orderResponseDto);
            orderResponseDto.setAddress(item.getAddress());
            orderResponseDto.setPhone(item.getPhone());
            orderResponseDto.setConsignee(item.getConsignee());
            orderResponseDto.setUserName(item.getUserName());
            //根据订单id查询订单详情
            Long orderId = item.getId();
            List<OrderDetail> orderDetailList = orderDetailService.list(new LambdaQueryWrapper<OrderDetail>().eq(OrderDetail::getOrderId, orderId));
            orderResponseDto.setOrderDetails(orderDetailList);
            return orderResponseDto;
        }).collect(Collectors.toList());
        res.setRecords(list);
        return R.success(res);
    }
}