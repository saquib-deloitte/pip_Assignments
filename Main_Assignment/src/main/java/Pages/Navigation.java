package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation {

    // path and opeartions in the class
    WebDriver driver;

    //Home Button
    @FindBy(xpath = "/html/body/div/div/div[1]/button[1]")
    WebElement home_button;

    public Navigation(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public boolean clickHome() {
            if(home_button.isEnabled()) {
                home_button.click();
                return true;
            }
            return false;
    }

}
