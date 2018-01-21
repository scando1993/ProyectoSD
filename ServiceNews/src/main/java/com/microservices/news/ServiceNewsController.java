/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.news;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceNewsController.class);
    
    private static final String template = "Hello, %s!";
    
    @Autowired
    private ServiceNews newsService;
    
    @RequestMapping(value = "/id/{idnews}", method = RequestMethod.GET)
    public News getNewsByidnews(@PathVariable("idnews") String idnews){
        LOGGER.info("getNewsByidnews called for id {}", idnews);
        int idNews = Integer.parseInt(idnews);
        return newsService.getNews(idNews);
    }

    @RequestMapping(value = "/date/{timestamp}", method = RequestMethod.GET)
    public List<News> getNewsByTimestamp(@PathVariable("timestamp") String timestamp){
        LOGGER.info("getNewsByTimestamp called for timestamp {}", timestamp);
        long timestampLong = Long.parseLong(timestamp);
        return newsService.getNewsTimestamp(timestampLong);
    }
    
}
