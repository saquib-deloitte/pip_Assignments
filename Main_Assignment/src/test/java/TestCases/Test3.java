package TestCases;

import Pages.*;
import Utils.DriverFactory;
import Utils.FetchData;
import Utils.ScreenShot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test3 {

    public List<List<String>> data = new ArrayList<>();

    int time = 10;
    static public int ssNumber = 3;

    String fName = "", lName = "", postalCode = "";
    String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    @BeforeClass
    public void TestBegin() {
        System.out.println("Test Started");

        data = FetchData.getTestData();

        fName = data.get(2).get(0);
        lName = data.get(2).get(1);
        postalCode = data.get(2).get(2);
    }

    @BeforeMethod
    public void DriverSetup() {
        DriverFactory.setDriver();
    }

    @Test
    void User3() {

        DriverFactory.getDriver().manage().window().maximize();

        Navigation navBar = new Navigation(DriverFactory.getDriver());
        Home home = new Home(DriverFactory.getDriver());
        BankManager bankManager = new BankManager(DriverFactory.getDriver());
        AddCustomer addCustomer = new AddCustomer(DriverFactory.getDriver());
        Customers allCustomers = new Customers(DriverFactory.getDriver());
        OpenAccount openAccount = new OpenAccount(DriverFactory.getDriver());
        Customer customer = new Customer(DriverFactory.getDriver());
        UserAccount userAccount = new UserAccount(DriverFactory.getDriver());
        Deposit deposit = new Deposit(DriverFactory.getDriver());
        Withdraw withdraw = new Withdraw(DriverFactory.getDriver());
        Transactions transactions = new Transactions(DriverFactory.getDriver());

        String user_id = "";
        String ac_num = "";
        int amount = 0;
        List<String> trscn = new ArrayList<>();

        //Url Test
        DriverFactory.getDriver().get(url);
        Assert.assertEquals(url, DriverFactory.getDriver().getCurrentUrl());

        //Click on Home by BankManager
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        Assert.assertTrue(home.clickLoginManager());


        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

        //Click on Add Customer
        Assert.assertTrue(bankManager.clickAddCustomer());

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

        //Adding new Customer Details
        Assert.assertTrue(addCustomer.enterFirstName(fName));
        Assert.assertTrue(addCustomer.enterLastName(lName));
        Assert.assertTrue(addCustomer.enterPostalCode(postalCode));
        Assert.assertTrue(addCustomer.clickAdd());

        user_id = DriverFactory.getDriver().switchTo().alert().getText().replace("Customer added successfully with customer id :", "");
        DriverFactory.getDriver().switchTo().alert().dismiss();

        //Creating new UserAccount for the Customer
        Assert.assertTrue(bankManager.clickOpenAccount());
        Assert.assertTrue(openAccount.selectCustomer(fName + " " + lName));
        Assert.assertTrue(openAccount.selectCurrency("Rupee"));
        Assert.assertTrue(openAccount.clickAddAccount());

        //Verifying that Customer is Details are Added
        ac_num = DriverFactory.getDriver().switchTo().alert().getText().replace("Account created successfully with account Number :", "");
        DriverFactory.getDriver().switchTo().alert().dismiss();
        Assert.assertTrue(bankManager.clickCustomers());
        Assert.assertTrue(allCustomers.searchCustomer(ac_num));

        Assert.assertTrue(navBar.clickHome());

        Assert.assertTrue(home.clickLoginCustomer());

        //Home as Registered User
        Assert.assertTrue(customer.clickSelectCustomer(fName + " " + lName));
        Assert.assertTrue(customer.clickLoginButton());

        Assert.assertTrue(userAccount.clickDeposit());

        Assert.assertTrue(deposit.enterAmount(-100));
        amount += -100;
        trscn.add(Integer.toString(-100));

        Assert.assertTrue(deposit.addAmount());
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));


        //Withdrawal
        Assert.assertTrue(userAccount.clickWithdraw());
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

        Assert.assertTrue(withdraw.enterAmount(50));
        amount -= 50;

        trscn.add(Integer.toString(-50));
        System.out.println(trscn);

        Assert.assertTrue(withdraw.withdrawAmount());
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));


        //Transactions
        Assert.assertTrue(userAccount.clickTransactions());
        DriverFactory.getDriver().navigate().refresh();
        Assert.assertTrue(userAccount.clickTransactions());
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

    }

    @AfterMethod
    public void ManageResults(ITestResult result) {
        try {
            if(result.getStatus() == ITestResult.SUCCESS) {
                System.out.println("Passed---------------------");
            } else if(result.getStatus() == ITestResult.FAILURE) {
                System.out.println("Failed---------------------");

            } else if(result.getStatus() == ITestResult.SKIP) {
                System.out.println("Skipped---------------------");
            }
            ScreenShot ss = new ScreenShot();
            ss.Shot(DriverFactory.getDriver(), ssNumber);
            DriverFactory.closeDriver();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            DriverFactory.closeDriver();
            e.printStackTrace();
        }
    }

    @AfterClass
    public void TestEnd() {
        System.out.println("Test Ended");
    }
}

