package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Withdraw {
    WebDriver driver;

    @FindBy(xpath = "//form[@ng-submit = 'withdrawl()']//descendant::input")
    WebElement amountEnter;

    @FindBy(xpath = "//form[@ng-submit = 'withdrawl()']//descendant::button")
    WebElement withdrawButton;


    public Withdraw(WebDriver webdriver) {
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

    public boolean withdrawAmount() {
        try {
            withdrawButton.click();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
