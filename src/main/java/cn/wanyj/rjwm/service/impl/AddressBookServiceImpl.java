package cn.wanyj.rjwm.service.impl;

import cn.wanyj.rjwm.entity.AddressBook;
import cn.wanyj.rjwm.mapper.AddressBookMapper;
import cn.wanyj.rjwm.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
