package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Customers {

    WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr")
    List<WebElement> details;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input")
    WebElement searchbar;

    public Customers(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public boolean searchCustomer(String ac_num) {
            for(WebElement e: details) {
                if(e.getText().contains(ac_num)) {
                    return true;
                }
            }
            return false;
    }

    public void search(String detail){
        searchbar.sendKeys(detail);
    }
}
