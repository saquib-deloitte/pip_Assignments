package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManager {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    WebElement add_customer;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    WebElement open_account;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[3]")
    WebElement customers;

    public BankManager(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public boolean clickAddCustomer() {
            if(add_customer.isEnabled()) {
                add_customer.click();
                return true;
            }
            return false;
    }

    public boolean clickOpenAccount() {
            if(open_account.isEnabled()) {
                open_account.click();
                return true;
            }
            return false;
    }

    public boolean clickCustomers() {
            if(customers.isEnabled()) {
                customers.click();
                return true;
            }
            return false;
    }
}
