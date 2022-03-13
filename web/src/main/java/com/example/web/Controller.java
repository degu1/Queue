package com.example.web;

import com.example.common.WebInterface;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller implements WebInterface {
    int i = 0;
    private WebInterface webInterfaceImpl;

    public Controller(WebInterface webInterfaceImpl) {
        this.webInterfaceImpl = webInterfaceImpl;
    }

    //@CircuitBreaker(name = "backendB", fallbackMethod = "fallback")
    //@RateLimiter(name = "backendB", fallbackMethod = "fallback")
    @GetMapping("/test")
    public String test() {
        if (2 <= i && i <= 4) {
            i++;
            throw new RuntimeException("Runtime ex " + i);
        }
        i++;
        return webInterfaceImpl.test() + " " + i;
    }

    @GetMapping("/test2")
    public String test2() {
        return "Jippi!!";
    }

    //private Mono<String> fallback(Throwable t) {
    //    return Mono.just("Fallback method");
    //}
    private String fallback(CallNotPermittedException e) {
        return "Fallback method" + e.getMessage();
    }

    @ExceptionHandler
    public String ex(Exception e) {
        return "exceptionHandler " + e.getMessage();
    }

}
