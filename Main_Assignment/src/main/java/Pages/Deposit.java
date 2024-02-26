package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deposit {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/div/input")
    WebElement amountEnter;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
    WebElement depositButton;


    public Deposit(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public boolean enterAmount(int amt) {
        try {
            amountEnter.sendKeys(Integer.toString(amt));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addAmount() {
        try {
            depositButton.click();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
