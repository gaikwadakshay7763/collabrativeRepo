package com.example.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

    public class ApplicationPropertiesLoader {
        private Map<String, String> propertiesMap;

        final String MAP_VALUE_FILE = "mapvalue.properties";

        public ApplicationPropertiesLoader(String MAP_VALUE_FILE) {
            propertiesMap = new HashMap<>();
            loadProperties(MAP_VALUE_FILE);
        }

        private void loadProperties(String MAP_VALUE_FILE) {


            Properties properties = new Properties();
            try (FileInputStream fis = new FileInputStream(MAP_VALUE_FILE)) {
                properties.load(fis);
                for (String key : properties.stringPropertyNames()) {
                    String value = properties.getProperty(key);
                    propertiesMap.put(key, value);
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Handle exception appropriately
            }
        }

        public String getProperty(String key) {
            return propertiesMap.get(key);
        }

        public Map<String, String> getPropertiesMap() {
            return propertiesMap;
        }
    }


