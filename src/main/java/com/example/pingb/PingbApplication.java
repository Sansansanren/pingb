package com.example.pingb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@ServletComponentScan
public class PingbApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(PingbApplication.class);
    }

    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("-------------------host:" + addr.getHostName());
        System.out.println("-------------------ip:" + addr.getHostAddress());
        SpringApplication.run(PingbApplication.class, args);


    }

}
