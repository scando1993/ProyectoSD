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
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author j3s
 */
@Service
public class ServiceNews {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceNews.class);
    
    @Autowired
    private NewsRepository repository;

    public News getNews(int id) {
        LOGGER.info("getNews called for id {}", id);
        return repository.findByIdnews(id);
    }

    @CacheEvict(cacheNames="newscache", key = "#timestamp") //Elimina esa consulta de la caché
    public List<News> getNewsTimestamp(long timestamp) {
        LOGGER.info("getNewsTimestamp called for timestamp {}", timestamp);
        return repository.findByTimestamp(timestamp);
    }
    
    @Cacheable(value = "newscache", key = "#from") // Agrega este resultado a la caché
    public List<News> getNewsInDay(long from, long to) {
        LOGGER.info("getNewsInDay called for timestamp {}", from, to);
        return repository.findByTimestampBetweenOrderByViewsDesc(from, to);
    }
}
