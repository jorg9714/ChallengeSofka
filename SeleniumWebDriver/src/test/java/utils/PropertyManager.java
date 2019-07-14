package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static final String PROPERTIES_FILENAME = "/config.properties";
    private static Properties properties;

    private PropertyManager() {
    }

    public static String getValueByKey(String key) {
        if (properties == null) {
            loadProperties();
        }
        return properties.get(key).toString();
    }

    private static Properties loadProperties() {
        try {
            properties = new Properties();
            properties.load(PropertyManager.class.getResourceAsStream(PROPERTIES_FILENAME));
        } catch (IOException e) {
        }
        return properties;
    }
}
