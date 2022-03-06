package com.example.web;

import com.example.common.WebInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller implements WebInterface {

    private WebInterface webInterfaceImpl;

    public Controller(WebInterface webInterfaceImpl) {
        this.webInterfaceImpl = webInterfaceImpl;
    }

    @GetMapping("/test")
    public String test() {
        return webInterfaceImpl.test();
    }
}
