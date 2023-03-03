package co.weathershoppers.assignment.helpers;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.io.FileWriter;
import java.util.Properties;
import static co.weathershoppers.assignment.helpers.PathHelper.getFile;
import static co.weathershoppers.assignment.helpers.PathHelper.getFolderWithFile;
import static co.weathershoppers.assignment.helpers.PathHelper.getDirectoryPath;


public class Log4jHelper {

    static final String propertiesFile = getFile("log4j.properties");
    static final String logFile = getFolderWithFile("logs", "TestingAutomationLogs.log");
    static final String logDirectory = getDirectoryPath("logs");

    public static void createPropertyFile() throws IOException {
        Properties props = new Properties();
        props.put("log4j.rootLogger", "DEBUG, stdout, file");
        props.put("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        props.put("log4j.appender.stdout.Target", "System.out");
        props.put("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
        props.put("log4j.appender.stdout.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
        props.put("log4j.appender.FILE", "org.apache.log4j.FileAppender");

        props.put("log4j.appender.file", "org.apache.log4j.RollingFileAppender");
        props.put("log4j.appender.file.File", logFile);
        props.put("log4j.appender.file.MaxFileSize", "5MB");
        props.put("log", logDirectory);
        props.put("log4j.appender.file.layout", "org.apache.log4j.PatternLayout");
        props.put("log4j.appender.file.layout.ConversionPattern", "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
        props.store(new FileWriter(propertiesFile), "Log4J Properties File");
        PropertyConfigurator.configure(propertiesFile);
    }

    public static Logger log() {
        return Logger.getLogger(
                Log4jHelper.class.getName());
    }

}


