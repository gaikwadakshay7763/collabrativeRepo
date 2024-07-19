//package com.course.utile;
//
//import org.apache.commons.configuration2.PropertiesConfiguration;
//import org.apache.commons.configuration2.builder.fluent.Configurations;
//import org.apache.commons.configuration2.ex.ConfigurationException;
//import org.springframework.stereotype.Component;
//
//@Component
//    public class PropertiesConfigurationManager {
//
//        private static final String PROPERTIES_FILE = "paymentInfo_Cielo.properties";
//        private static final long REFRESH_INTERVAL_MILLIS = 15 * 1000;
//
//        private PropertiesConfiguration configuration;
//
//        public PropertiesConfigurationManager() throws ConfigurationException {
//            initializeConfiguration();
//        }
//
//        private void initializeConfiguration() throws ConfigurationException {
//            Configurations configs = new Configurations();
//            configuration = configs.properties(PROPERTIES_FILE);
//        }
//
//        public PropertiesConfiguration getConfiguration() {
//            return configuration;
//        }
//    }
//
//
//
