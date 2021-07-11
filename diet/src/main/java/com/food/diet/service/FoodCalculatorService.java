package com.food.diet.service;

import com.food.diet.model.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCalculatorService {
    public int calculate(List<Food> foods) {
        int total_cal = 0;
        for(Food food : foods) {
            total_cal += food.getDan() + food.getJi() + food.getTan();
        }

        return total_cal;
    }
}
