package com.jojoldu.book.spring.web;

import com.jojoldu.book.spring.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// JSON 반환 Controller 생성(기존 @ResponseBody)
@RestController
public class HelloController {

    // HTTP METHOD GET 요청 API 처리(기존 @RequestMappping(method = RequestMethod.GET))
    @GetMapping("/hello")
    public String Hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    // @RequestParam 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);

    }
}

