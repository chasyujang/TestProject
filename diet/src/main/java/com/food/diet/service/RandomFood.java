package com.food.diet.service;

import com.food.diet.model.Food;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RandomFood {
    String[] list = {"냉면","돈까스","햄버거"};
    public String Random() {

        int idx = (int)((Math.random()*10000)%3);
        return list[idx];
    }

}
