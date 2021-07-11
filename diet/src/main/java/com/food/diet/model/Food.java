package com.food.diet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // 로그로 출력 시, 객체에 어떤 값이 들어 있었는지를 알고 싶을 때 사용함 ex) log.info(food);
public class Food {
    private String name;
    private int tan;
    private int ji;
    private int dan;

}
