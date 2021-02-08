package utils;

import java.io.IOException;
import java.util.Properties;

public class TestData {

    private static Properties properties;

    public static String getProperty(String key) {
        if (properties == null) {
            properties = readProperties();
        }
        return properties.getProperty(key);
    }

    private static Properties readProperties() {
        properties = new Properties();
        String propertyFile = "/testData.properties";
        try {
            properties.load(TestData.class.getResourceAsStream(propertyFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
