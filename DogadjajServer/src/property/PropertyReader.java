package property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PropertyReader {

    private static PropertyReader instance;
    Properties prop;
    private static String trenutnaDB = "mysql";

    private PropertyReader() {

        ucitajPodatke();
    }

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();

        }

        return instance;
    }

    private void ucitajPodatke() {
        FileInputStream fis = null;
        try {
            prop = new Properties();
            fis = new FileInputStream("db.properties");
            prop.load(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(PropertyReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getDriver() {
        //System.out.println("drajver:" + prop.getProperty(trenutnaDB + "_driver"));
        return prop.getProperty(trenutnaDB + "_driver");
    }

    public String getURL() {
        return prop.getProperty(trenutnaDB + "_url");
    }

    public String getUsername() {
        return prop.getProperty(trenutnaDB + "_username");
    }

    public String getPassword() {
        return prop.getProperty(trenutnaDB + "_password");
    }

}
