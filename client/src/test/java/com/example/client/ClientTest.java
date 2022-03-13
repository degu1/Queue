package com.example.client;

import com.example.common.WebInterface;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


class ClientTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    private WebInterface client = context.getBean(Client.class);

    @Test
    void test1() {

        // client.test();
        for (int i = 0; i < 10; i++) {
            System.out.println(client.test());
        }

    }

}