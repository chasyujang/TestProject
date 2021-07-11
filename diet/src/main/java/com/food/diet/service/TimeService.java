package com.food.diet.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TimeService {
    public LocalDateTime currentTime() {
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate;
    }

}
