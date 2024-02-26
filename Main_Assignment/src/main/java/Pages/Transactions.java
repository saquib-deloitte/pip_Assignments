package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Transactions {
    WebDriver driver;

    @FindBy(xpath = "//tbody//descendant::tr//td[2]")
    List<WebElement> amount;

    @FindBy(xpath = "//tbody//descendant::tr//td[3]")
    List<WebElement> types;


    public Transactions(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public boolean verify(List<String> tr){
        boolean flag = false;
        for(int i=0;i<types.size();i++){
            System.out.println(types.get(i).getText());
            if(types.get(i).getText().equals("Credit")){
                if(amount.get(i).getText().equals(tr.get(i)))
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            else if (types.get(i).getText().equals("Debit")){
                if(amount.get(i).getText().equals(tr.get(i).replace("-","")))
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
