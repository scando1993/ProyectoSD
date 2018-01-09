/*
 * Modelo para la colección news que contiene todas las noticias
 */
package com.microservices.news;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author j3s
 */
@Document(collection = "news")
public class News {
    
    @Id
    private ObjectId _id;;

    @Field(value="idnews")
    public int idnews;
    @Field(value="title")
    public String title;
    @Field(value="url")
    public String url;
    @Field(value="publisher")
    public String publisher;
    @Field(value="category")
    public String category;
    @Field(value="story")
    public String story;
    @Field(value="hostname")
    public String hostname;
    @Field(value="timestamp")
    public long timestamp;
    @Field(value="views")
    public int views;

    public News() {
    }

    @PersistenceConstructor
    public News(int idnews, String title, String url, String publisher,
            String category, String story, String hostname, long timestamp, 
            int views) {
        super();
        this.idnews = idnews;
        this.title = title;
        this.url = url;
        this.publisher = publisher;
        this.category = category;
        this.story = story;
        this.hostname = hostname;
        this.timestamp = timestamp;
        this.views = views;
    }

    @Override
    public String toString() {
        return String.format(
                "News[idnews=%d, title='%s', url='%s',publisher=%s, "
                        + "category='%s', story='%s', hostname='%s', "
                        + "timestamp='%d%n', views='%d']",
                idnews, title, url, publisher, category, story, hostname, 
                timestamp, views);
    }
    
}
