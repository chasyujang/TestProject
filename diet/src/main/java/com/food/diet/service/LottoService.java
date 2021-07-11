package com.food.diet.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class LottoService {
    int[] arr=new int[6];
    public LocalDateTime CurrentTime(){
        LocalDateTime currentDate = LocalDateTime.now();
        return currentDate;
    }

    public int[] RandomNumber(){
        for(int i=0;i<6;i++) {
            int number = (int) (Math.random() * 45 + 1);
            int flag=0;
            for(int j=0;j<6;j++){
                if(arr[j]==number){
                    i--;
                    flag=1;
                    break;
                }
            }
            if(flag==1) break;
            arr[i]=number;
        }
        Arrays.sort(arr);
        return arr;
    }
}
