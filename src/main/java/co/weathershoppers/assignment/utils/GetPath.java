package co.weathershoppers.assignment.utils;

public class GetPath {
    public static String getFile(String filename) {
        String absoluteFilePath = "";
        try {

            String your_os = System.getProperty("os.name").toLowerCase();
            String workingDir;

            workingDir = System.getProperty("user.dir");
            String directoryName;
            if (your_os.contains("win")) {
                directoryName = "src\\main\\resources\\";
                absoluteFilePath = workingDir + "\\" + directoryName + "\\" + filename;
            } else if (your_os.contains("nix") ||
                    your_os.contains("nux") ||
                    your_os.contains("mac")) {
                directoryName = "src/main/resources/";
                absoluteFilePath = workingDir + "/" + directoryName + "/" + filename;
            } else {
                directoryName = "src/main/resources/";
                absoluteFilePath = workingDir + "/" + directoryName + "/" + filename;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return absoluteFilePath;
    }

    public static String getDirectoryPath(String directoryName) {
        String absoluteFilePath = "";
        try {

            String your_os = System.getProperty("os.name").toLowerCase();
            String workingDir;

            workingDir = System.getProperty("user.dir");
            String directoryPath;
            if (your_os.contains("win")) {
                directoryPath = "src\\main";
                absoluteFilePath = workingDir + "\\" + directoryPath + "\\" + directoryName;
            } else if (your_os.contains("nix") ||
                    your_os.contains("nux") ||
                    your_os.contains("mac")) {
                directoryPath = "src/main";
                absoluteFilePath = workingDir + "/" + directoryPath + "/" + directoryName;
            } else {
                directoryPath = "src/main";
                absoluteFilePath = workingDir + "/" + directoryPath + "/" + directoryName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return absoluteFilePath;
    }

    public static void main(String[] args){
        System.out.println(getDirectoryPath("logs"));
    }
}
