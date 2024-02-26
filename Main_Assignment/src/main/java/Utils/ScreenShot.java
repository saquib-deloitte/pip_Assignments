package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public void Shot(WebDriver driver, int ss) {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            File dest= new File("C:\\Users\\mohamsaquib\\Desktop\\Main_Assignment\\Screenshots\\ss_" + ss + timestamp() + ".png");
            FileUtils.copyFile(src, dest);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}