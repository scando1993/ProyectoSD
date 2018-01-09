/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.news;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author j3s
 */
@EnableAutoConfiguration
// Registro del servicio en Eureka
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceNewsApp {
    
    
    protected Logger logger = Logger.getLogger(ServiceNewsApp.class.getName());

    /**
     * Correr la aplicación usando Spring Boot
     *
    /**
     * @param args
     */
    public static void main(String[] args) {
            SpringApplication.run(ServiceNewsApp.class, args);
    }
    
}
