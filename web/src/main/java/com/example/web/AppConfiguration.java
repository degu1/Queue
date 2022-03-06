package com.example.web;

import com.example.common.Communication;
import com.example.communication_service.Email;
import com.example.core.Core;
import com.example.dao.DaoImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }

    @Bean
    public Core webInterface() {
        return new Core(daoImpl(), communicationImpl());
    }

    @Bean
    public DaoImpl daoImpl() {
        return new DaoImpl();
    }

    @Bean
    public Communication communicationImpl() {
        return new Email();
    }
}
