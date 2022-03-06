package com.example.core;

import com.example.common.Communication;
import com.example.common.Dao;
import com.example.common.WebInterface;
import com.example.dao.DaoImpl;

public class Core implements WebInterface {

    Dao dao;
    Communication communication;

    public Core(DaoImpl dao, Communication communication) {
        this.dao = dao;
        this.communication = communication;
    }

    @Override
    public String test() {
        String str = dao.getTest();
        communication.Send(str);
        return str;
    }
}
