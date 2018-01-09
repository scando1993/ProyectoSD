/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.news;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author j3s
 */
@RestController
@RequestMapping("/news")
public class ServiceNewsController {
    
    private static final String template = "Hello, %s!";
    
    @Autowired
    private NewsRepository repository;
	
    /**
     * Say Hello
     * 
     * @param name
     * @return a greeting "Hello" + name	
     */	
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String greeting2(@PathVariable("name") String name) {
        return String.format(template, name) ;		
    }
    
    @RequestMapping(value = "/id/{idnews}", method = RequestMethod.GET)
    public List<News> getNewsByidnews(@PathVariable("idnews") String idnews){
        System.out.println(idnews);
        int idNews = Integer.parseInt(idnews);
        System.out.println(repository.findByIdnews(idNews));
        return repository.findByIdnews(idNews);
    }

    @RequestMapping(value = "/date/{timestamp}", method = RequestMethod.GET)
    public List<News> getNewsByTimestamp(@PathVariable("timestamp") String timestamp){
        return repository.findByTimestamp(timestamp);
    }
    
}
