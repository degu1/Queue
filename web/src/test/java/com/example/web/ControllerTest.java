package com.example.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class ControllerTest {

    private WebClient webClient = WebClient.create("http://localhost:8080");

    @Test
    void test1() {
        var response = webClient.get().uri("test").retrieve().bodyToMono(String.class);
        response.doFirst(System.out::println);
    }

    @Test
    void test2() {
        var response = webClient.get().uri("test2").retrieve().bodyToMono(String.class).block();

    }
}