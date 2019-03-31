/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerise.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Carlos Vieira
 */
public class PropertiesManager {

    private File propertiesFile;

    private Properties properties;

    public PropertiesManager(File propertiesFile) {
        this.properties = initializeProp(propertiesFile);
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key).trim();
    }

    private Properties initializeProp(File propertiesFile) {
        this.propertiesFile = propertiesFile;
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(this.propertiesFile);
            // load a properties file
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
