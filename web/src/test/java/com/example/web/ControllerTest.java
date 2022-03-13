package com.example.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {
    @LocalServerPort
    private static int port;

    private static WebClient webClient;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("port " + port);
        webClient = WebClient.create("http://localhost:" + port);
    }

    @Test
        //@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
    void test1() {

        var response = webClient.get().uri("/test/").retrieve().bodyToMono(String.class);
        response.subscribe(
                value -> System.out.println(value),
                error -> error.printStackTrace(),
                () -> System.out.println("is empty"));
        //System.out.println(response.block());


    }

    @Test
    void test2() {
        var response = webClient.get().uri("/test2").retrieve().bodyToMono(String.class).block();

    }
}