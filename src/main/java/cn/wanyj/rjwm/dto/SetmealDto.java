package cn.wanyj.rjwm.dto;

import cn.wanyj.rjwm.entity.Setmeal;
import cn.wanyj.rjwm.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
