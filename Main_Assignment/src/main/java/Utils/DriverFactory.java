package Utils;

//import io.github.bonigarcia.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

//    public static WebDriver driver;
    public static void setDriver() {

        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().close();
        driver.remove();
    }

}
