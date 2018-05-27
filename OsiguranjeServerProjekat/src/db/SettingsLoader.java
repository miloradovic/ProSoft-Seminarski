package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Darko
 */
public class SettingsLoader {

    private static SettingsLoader instance;

    private Properties properties;

    private SettingsLoader() throws FileNotFoundException, IOException {
        loadProperties();
    }

    public static SettingsLoader getInstance() throws IOException {
        if (instance == null) {
            instance = new SettingsLoader();
        }
        return instance;
    }

    private void loadProperties() throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("settings.properties");
        properties = new Properties();
        properties.load(fis);
    }

    private void saveProperties(Properties prop) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("settings.properties");
        properties.store(fos, "");
    }
    
    public String getValue(String key) {
        return properties.getProperty(key, "n/a");
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    
    
}
