package com.example.communication_service;

import com.example.common.Communication;

public class Email implements Communication {
    @Override
    public void Send(String str) {
        System.out.println("Email to " + str);
    }
}
