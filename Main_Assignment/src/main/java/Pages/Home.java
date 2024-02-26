package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

    WebDriver driver;

    //Customer Home
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[1]/button")
    WebElement customer;

    //BankManager Home
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[2]/button")
    WebElement manager;

    //Home Button
    @FindBy(xpath = "/html/body/div/div/div[1]/button[1]")
    WebElement home_btn;

    public Home(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    String getTitle() {
        return driver.getTitle();
    }

    public boolean clickLoginCustomer() {
        if (!customer.isEnabled())
            return false;

        customer.click();
        return true;
    }

    public boolean clickLoginManager() {
            if(!manager.isEnabled())
                return false;

            manager.click();
            return true;
    }
}
