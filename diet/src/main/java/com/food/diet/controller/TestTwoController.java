package com.food.diet.controller;

import com.food.diet.model.TestBody;
import com.food.diet.service.FoodCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestTwoController {
    private final FoodCalculatorService foodCalculatorService;

    // http method (전세계 공통 규약)
    // get / post / put / delete
    // get : 데이터 요청 할 때 사용
    // post : 데이터를 db 에 저장을 오청할 때, 데이터를 body 에 실어서 보냄. 이유는 저장하려는 데이터가 보통 크기나 길이가 길이 때문에 body 로 숨겨서 보냄
    // put : db 에 있는 데이터를 수정을 요청할 때, 위와 동일
    // delete : db 에 있는 데이터를 삭제를 요청할 때, path variable 을 통해서 데이터 삭제 요청, path variable 에는 db의 id 값을 실어서 보냄
    // https://developer.mozilla.org/ko/docs/Web/HTTP/Methods


    // get method 에서 서버쪽으로 유동적인 데이터들을 실어서 보내주고자 했을 때 사용하는 방법 두 가지
    // 1. 쿼리 스트링
    // 2. path variable
    // 3. 아주 특수한 경우에는 body 에 데이터를 실어서 보냄

    // localhost:8080/toUpperCase?str=aasdfsdfSDVE : ? 뒤에 오는 값들은 쿼리스트링이라고 부른다.
    // 서버에 질문을 하기 위한 데이터들을 실어서 보냄
    @GetMapping("/toUpperCase")
    public String toUpper(String str) {
        return str.toUpperCase();
  }

  // @RequestParam("some") : 쿼리 스트링의 some 이라는 key 의 값을 str 변수로 매칭시켜서 넣어준다.
    @GetMapping("/toUpperCase2")
    public String toUpper2(@RequestParam("some") String str) {
        return str.toUpperCase();
    }

    // @PathVariable("some") : 경로 상에 유동적 데이터 값을 실어서 보내줌
    @GetMapping("/toUpperCase3/{some}/test")
    public String toUpper3(@PathVariable("some") String str) {
        return str.toUpperCase();
    }

    @PostMapping("/toTestUpper")
    public String toTestUpper(@RequestBody TestBody testBody){
        return testBody.getSex().toUpperCase();
    }

}
