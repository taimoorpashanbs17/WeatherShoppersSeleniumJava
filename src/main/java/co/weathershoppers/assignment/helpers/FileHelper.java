package co.weathershoppers.assignment.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static co.weathershoppers.assignment.helpers.Log4jHelper.log;

public class FileHelper {

    public static Properties getPropertiesFileProperty(String fileName) {
        Properties properties = new Properties();
        try {
            FileReader reader = new FileReader(fileName);
            properties.load(reader);
        } catch (FileNotFoundException e) {
            log().error("Unable to find file due to " + e.getMessage());
        } catch (IOException e) {
            log().error("Unable to read properties due to " + e.getMessage());
        }
        return properties;
    }

}
