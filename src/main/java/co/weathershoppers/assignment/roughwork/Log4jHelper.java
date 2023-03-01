package co.weathershoppers.assignment.roughwork;
import co.weathershoppers.assignment.utils.GetPath;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class Log4jHelper {
    static Logger log = Logger.getLogger(Log4jHelper.class.getName());
    static final String logPath = GetPath.getDirectoryPath("logs");
    static final String logFilePath = logPath + "/test.log";

    public static void main(String[] args) throws IOException {
//        PropertyConfigurator.configure(path);
//        PropertyConfigurator.configure(path);
//
//        log.debug("Hello this is a debug message");
//        log.info("Hello this is an info message");
//        log.error("This is error Message");

        Properties props = new Properties();
        //Populating the properties file
        props.put("log4j.appender.FILE", "org.apache.log4j.FileAppender");
        props.put("log4j.rootLogger", "debug");
        props.put("log4j.appender.FILE.layout", "org.apache.log4j.PatternLayout");
        props.put("log4j.appender.FILE.layout.conversionPattern", "org.apache.log4j.PatternLayout");
        props.put("log", logPath);
        props.put("log4j.appender.FILE.File", logFilePath);
//        props.put("CPU", "Snapdragon855");
        //Instantiating the FileInputStream for output file
        String path = "/Users/tp/Documents/Pract/WeatherShoppersSeleniumJava/log4j.properties";
        FileOutputStream outputStrem = new FileOutputStream(path);
        //Storing the properties file
        props.store(outputStrem, "This is a sample properties file");
        PropertyConfigurator.configure("/Users/tp/Documents/Pract/WeatherShoppersSeleniumJava/log4j.properties");
        System.out.println("Properties file created......");
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
        log.error("This is error Message");
        System.out.println(logFilePath);
    }
}


