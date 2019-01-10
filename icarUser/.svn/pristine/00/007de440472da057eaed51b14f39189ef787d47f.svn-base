package com.ybinsure.icar.user.listener;

import com.ybinsure.icar.user.util.HttpUtil;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * 注销JDBC drivers
 * create by HANHT on 2018/4/20 19:05
 */
@WebListener
public class DeregisterListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("DeregisterListener contextInitialized...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("DeregisterListener contextDestroyed...");
        // 注销所有JDBC驱动
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(drivers.nextElement());
                System.out.println("deregistering JDBC drivers");
            } catch (SQLException e) {

                System.out.println("Exception caught while deregistering JDBC drivers : " + e.getMessage());
            }
        }

        // 注销okhttp连接池
        OkHttpClient http = HttpUtil.OKHTTP;
        if (http != null) {
            ConnectionPool okhttpPoll = http.connectionPool();
            if (okhttpPoll != null) {
                System.out.println("okhttpPoll size : " + okhttpPoll.connectionCount());
                okhttpPoll.evictAll();
                System.out.println("deregistering okhttp ConnectionPool");
            }
        }

        System.out.println("DeregisterListener contextDestroyed success...");
    }
}
