package com.example.util;


import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Component
public class MyLogger {

   private static Logger logger = Logger.getLogger(MyLogger.class.getName());


   FileHandler logTxt;


    {
        try {
            logTxt = new FileHandler("C://Users//akshaygaik//Desktop//logFolder");
            logger.addHandler(logTxt);
            SimpleFormatter formatter = new SimpleFormatter();
            logTxt.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void info(String message){
        logger.info(message);
    }

   public void info1(String format,Object args){
       String message = String.format(format,args);
       logger.info(message);


   }

   public void warn(String message){
       logger.log(Level.WARNING,message);
   }


}
