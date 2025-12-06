package cn.wanyj.rjwm.dto;

import cn.wanyj.rjwm.entity.OrderDetail;
import cn.wanyj.rjwm.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrderResponseDto extends Orders {

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;

}
