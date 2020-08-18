package com.aktia.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.aktia.aktia3.AktiaDao;

//Käynnistyksessä tyhjentää kannan ja lisää sinne valmiita arvoja
@WebListener
public class StartUpServlet implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
    	AktiaDao.clearDb();
        AktiaDao.addStart();
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    }

}