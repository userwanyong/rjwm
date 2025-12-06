package cn.wanyj.rjwm.service;

import cn.wanyj.rjwm.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CategoryService extends IService<Category> {

    public void remove(Long id);

}
