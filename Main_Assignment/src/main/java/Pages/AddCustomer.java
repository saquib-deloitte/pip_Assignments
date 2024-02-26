package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")
    WebElement fname;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")
    WebElement lname;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")
    WebElement pcode;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/button")
    WebElement add_cust;

    public AddCustomer(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public boolean enterFirstName(String fName) {
            if(fname.isEnabled()) {
                fname.sendKeys(fName);
                return true;
            }
            return false;
    }

    public boolean enterLastName(String lName) {
        if(lname.isEnabled()) {
            lname.sendKeys(lName);
            return true;
        }
        return false;
    }

    public boolean enterPostalCode(String pCode) {
        if(pcode.isEnabled()) {
            pcode.sendKeys(pCode);
            return true;
        }
        return false;
    }

    public boolean clickAdd() {
            if(add_cust.isEnabled()) {
                add_cust.click();
                return true;
            }
            return false;
    }

}
