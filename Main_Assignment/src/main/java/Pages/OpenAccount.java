package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpenAccount {

    WebDriver driver;

    //PageFactory

    @FindBy(xpath = "//*[@id='userSelect']/option")
    List<WebElement> customerList;

    @FindBy(xpath = "//*[@id='currency']/option")
    List<WebElement> currencyList;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/button")
    WebElement process;

    public OpenAccount(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public boolean selectCustomer(String name) {
        for(WebElement element: customerList) {
            if(element.getText().equals(name)) {
                element.click();
                return true;
            }
        }
        return false;
    }

    public boolean selectCurrency(String currency) {
        for(WebElement element: currencyList) {
            if(element.getText().equals(currency)) {
                element.click();
                return true;
            }
        }
        return false;
    }

    public boolean clickAddAccount() {
        try {
            process.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
