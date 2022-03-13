package com.example.client;

import com.example.common.WebInterface;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    /*
        @Bean(autowire = Autowire.BY_TYPE)
        public WebClient webClient(){
            return WebClient.create("http://localhost:8080");
        }

     */
    @Bean
    public WebInterface webInterface() {
        return new Client();
    }

    @Bean
    public CircuitBreakerConfigCustomizer testCustomizer() {
        return CircuitBreakerConfigCustomizer
                .of("backendA", builder -> builder.slidingWindowSize(10));
    }
}
