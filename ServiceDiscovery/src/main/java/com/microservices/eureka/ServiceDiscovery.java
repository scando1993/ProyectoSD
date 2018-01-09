/*
 * Eureka registration server
 */
package com.microservices.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author j3s
 */

// Aplicación Spring Boot
@SpringBootApplication
// Habilitar el uso de Eureka como servidor de registro y descubrimiento de  microservicios
@EnableEurekaServer
public class ServiceDiscovery {
    
    	/**
	 * Levantar instancia de este servidor con Spring Cloud
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		SpringApplication.run(ServiceDiscovery.class, args);
	}
    
}
