package com.example.client;

import com.example.common.WebInterface;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class Client implements WebInterface {
    int i = 0;
 /*
    @Autowired
    private WebClient webClient;

    public Client(WebClient webClient) {
        this.webClient = webClient;
    }

    public Client(WebClient webClient) {
        System.out.println(webClient.toString());
        this.webClient = webClient;
    }

 */

    @CircuitBreaker(name = "backendA", fallbackMethod = "fallback")
    public Mono<String> test() {
        //return webClient.get().uri("/test").retrieve().bodyToMono(String.class).toString();
        if (i++ > 4) {
            throw new RuntimeException("jippi rumtime");
        }

        return "Jippi!!!!";
    }

    private String fallback(String param1, RuntimeException e) {
        return "fallback";
    }
}
