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

	/**
	 * The file where the properties reside
	 */
    private File propertiesFile;

    /**
     * Java property object
     */
    private Properties properties;

    /**
     * Creates a valid PropertiesManager
     * @param propertiesFile the file where the properties reside
     */
    public PropertiesManager(File propertiesFile) {
        this.properties = initializeProp(propertiesFile);
    }

    /**
     * Gets a property of a given key
     * @param key 
     * @return
     */
    public String getProperty(String key) {
        return this.properties.getProperty(key).trim();
    }

    /**
     * Initializes the Porperties java object and loads the properties from the file
     * @param propertiesFile
     * @return
     */
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
