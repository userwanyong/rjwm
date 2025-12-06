package cn.wanyj.rjwm.service.impl;

import cn.wanyj.rjwm.entity.Employee;
import cn.wanyj.rjwm.mapper.EmployeeMapper;
import cn.wanyj.rjwm.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
