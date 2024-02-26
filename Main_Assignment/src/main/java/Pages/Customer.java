package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Customer {

    WebDriver driver;

    //PageFactory
    @FindBy(xpath = "//*[@id='userSelect']/option")
    List<WebElement> selectCustomer;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/form/button")
    WebElement loginButton;

    public Customer(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public boolean clickSelectCustomer(String name) {
        try {
            for(WebElement element: selectCustomer) {
                if(element.getText().contains(name)) {
                    element.click();
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickLoginButton() {
        try {
            loginButton.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
