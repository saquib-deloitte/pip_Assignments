package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccount {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/strong/span")
    WebElement name;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[1]")
    WebElement ac_num;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[2]")
    WebElement amount;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[2]")
    WebElement currency;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[3]/button[1]")
    WebElement transactions;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[3]/button[2]")
    WebElement deposit;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[3]/button[3]")
    WebElement withdraw;

    public UserAccount(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public String getName() {
        return name.getText();
    }

    public String getAccountNumber() {
        return ac_num.getText();
    }

    public String getAmount() {
        return amount.getText();
    }

    public String getCurrency() {
        return currency.getText();
    }

    public boolean clickTransactions() {
        try {
            transactions.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickDeposit() {
        try {
            deposit.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickWithdraw() {
        try {
            withdraw.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
