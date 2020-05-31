package com.jojoldu.book.spring.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 테스트 실행 시 별도의 실행자를 실행(SpringRunner 라는 스프링 실행자 사용)
// 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@RunWith(SpringRunner.class)
@WebMvcTest    // Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    // 스프링이 관리하는 Bean 주입
    @Autowired
    private MockMvc mvc;    // 스프링 MVC 테스트의 시작점, HTTP GET, POST 등에 대한 API 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통한 HTTP GET 요청, 체이닝 지원을 통홰 여러 검증 기능을 이어서 선언 가능
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())             // HTTP Header Status 검증
                .andExpect(content().string(hello));    // 응답 본문 내용 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)    // API 요청 파라미터 설정, STRING만 허용
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
