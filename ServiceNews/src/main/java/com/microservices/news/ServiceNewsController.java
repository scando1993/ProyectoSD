/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservices.news;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @RequestMapping(value = "/day/{timestamp}", method = RequestMethod.GET)
    public List<News> getNewsByDay(@PathVariable("timestamp") String timestamp) throws ParseException{
        LOGGER.info("getNewsByDay called for timestamp {}", timestamp);
        // Fecha inicio
        long timestampLong = Long.parseLong(timestamp);
        Timestamp stamp = new Timestamp(timestampLong);
        Date date = new Date(stamp.getTime());
        Calendar calInicio = Calendar.getInstance();
        calInicio.setTime(date);
        int yearI = calInicio.get(Calendar.YEAR);
        int monthI = calInicio.get(Calendar.MONTH) + 1;
        int dayI = calInicio.get(Calendar.DAY_OF_MONTH);
//        System.out.println(date);
//        System.out.println(dayI + "-" + monthI + "-" + yearI); 
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calFrom  = Calendar.getInstance();
        calFrom.setTime(df.parse(dayI + "." + monthI + "." + yearI));
        System.out.println("Fecha de inicio: " + calFrom.getTime());

//        Fecha final
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(calFrom.getTime()); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, 23); // adds 23 hours
        cal.add(Calendar.MINUTE, 59); // adds 59 min
        cal.add(Calendar.SECOND, 59); // adds 59 sec
        System.out.println("Fecha de final: " + cal.getTime()); // returns new date object, one hour in the future
        return newsService.getNewsInDay(timestampLong, cal.getTime().getTime());
    }
    
//    @RequestMapping(value = "/date/", method = RequestMethod.POST)
//    public ResponseEntity < String > persistPerson(@PathVariable("timestamp") long timestamp) {
//        
//        if (timestamp != null) {
//            personRepository.persist(person);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        }
//        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
//    }
    
}
