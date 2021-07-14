package com.food.diet.controller;

import com.food.diet.model.Food;
import com.food.diet.model.FoodList;
import com.food.diet.service.FoodCalculatorService;
import com.food.diet.service.LottoService;
import com.food.diet.service.RandomFood;
import com.food.diet.service.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

// Json 타입으로 리턴해준다는 뜻
@RestController
// @ : 어노테이션이라고 부르며, 스프링에서 어노테이션이 붙은 클래스나 함수의 코드를 빌드시 변경시키거나 생성해줌.
// 어노테이션 마다 다르게 변경함.
// 어노테이션 중에 롬복이 유명하며, 노가다 코드를 알아서 생성해줌. 웬만한 노가다 코드는 롬복으로 해결 가능함
@RequiredArgsConstructor
// 클래스는 설계도에 불과해서 의미가 없음
public class TestController {
    // 멤버 변수 : 외부에서 TestController 객체를 생성할 때, FoodCalculatorService 객체도 생성해서 이쪽에 주입하여 생성해주어야 함
    // singleton 디자인 패턴 : 전역에서 하나의 객체만을 사용해서 구조를 만든 것, 스프링 프레임워크에서 알아서 만들어주고 주입을 해줌.
    // @RestController @Service @Configuration @Component @Bean 를 붙이면 객체를 만들어주고 싱글튼으로 스프링이 알아서  관리해줌.
    // Framework vs. Library ? 가장 큰 차이점은 Inversion of Control (IoC) 가 적용되어 있는지 여부. 프레임워크는 IoC 가 적용되어 있고,
    // 라이브러리는 적용 안되어 있음.
    // IoC 란? 제어의 역전으로 라이브러리는 프로그래머가 가져가 로직을 작성하는데 사용하는 것, 프레임워크는 이미 만들어져 있는 로직이 있고, 필요한 부분에만 프로그래머가
    // 로직을 작성해서 프로그램 전체를 완성하는 것.
    private final FoodCalculatorService foodCalculatorService;
    private final RandomFood randomFood;
    private final TimeService timerService;
    private final LottoService lottoService;
// test
    // 생성자 : CONSTRUCTOR
//    public TestController(FoodCalculatorService foodCalculatorService) {
//        this.foodCalculatorService = foodCalculatorService;
//    }



    // 자원의 위치 (url)
    @GetMapping("/test")
    public int test(@RequestBody FoodList foods) {
        // 데이터를 리턴함
        return foodCalculatorService.calculate(foods.getFoods());
    }

    @GetMapping("/random-food")
    public String getRandomFood() {
        // 데이터를 리턴함
        return randomFood.Random();
    }

    @GetMapping("/timer")
    public LocalDateTime getTime(){
        return timerService.currentTime();
    }
    // 로또 : 정렬, 6자리, 중복X, 50ms 아래, 45이하

    @GetMapping("/lotto")
    public int[] randomNumber(){
        return lottoService.RandomNumber();
    }

}
