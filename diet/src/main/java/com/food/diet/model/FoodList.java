package com.food.diet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

public class FoodList {
    private List<Food> foods;
}
