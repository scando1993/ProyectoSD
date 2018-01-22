/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.news;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author j3s
 */
public interface NewsRepository extends MongoRepository<News, ObjectId> {
    
    public List<News> findByTimestamp(long timestamp);
    public List<News> findByTimestampBetweenOrderByViewsDesc(long from, long to);
    public News findByIdnews(int idnews);
    
}
