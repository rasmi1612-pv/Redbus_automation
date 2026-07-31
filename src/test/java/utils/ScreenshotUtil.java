package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.BaseClass;

public class ScreenshotUtil {

    public static String takeScreenshot(String name) {
        try {
            String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            File src = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);

            // Folder inside project
            String folderPath = System.getProperty("user.dir") + "\\screenshots\\";

            // Create folder if missing
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Final file path
            String path = folderPath + name + "_" + ts + ".png";

            FileHandler.copy(src, new File(path));

            return path;

        } catch (Exception e) {
            System.out.println("Screenshot Error: " + e.getMessage());
            return null;
        }
    }
}
