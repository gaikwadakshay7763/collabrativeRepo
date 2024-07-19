//package com.course.service;
//
//import com.course.utile.PropertiesConfigurationManager;
//import org.apache.commons.configuration2.PropertiesConfiguration;
//import org.apache.logging.log4j.LogManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//import java.util.logging.Logger;
//
//@Component
//public class AccessPropertiesFromFile {
//
//   private PropertiesConfigurationManager propertiesConfigurationManager;
//
//    @Autowired
//    public AccessPropertiesFromFile(PropertiesConfigurationManager propertiesConfigurationManager) {
//        this.propertiesConfigurationManager = propertiesConfigurationManager;
//    }
//    public PropertiesConfiguration getConfiguration() {
//        return propertiesConfigurationManager.getConfiguration();
//    }
//
//
//    public Integer planCode(final String paymentPlanCode ) {
//        getConfiguration();
//        final int numericCode = this.propertiesConfigurationManager.getConfiguration().getInt(paymentPlanCode);
//        return Optional.ofNullable(numericCode).orElseGet(() -> {
//            //logger.log(info,"No mapping found, Add Mapping in properties file for {}", paymentPlanCode);
//            return null; // Return null or any appropriate default value
//        });
//
//    }
//}
