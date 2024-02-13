import com.aventstack.extentreports.ExtentReports;
import org.example.ExtentReportConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected ExtentReports extent;

    @BeforeMethod
    public void setUp() {
        extent = ExtentReportConfig.setUp();
    }

    @AfterMethod
    public void tearDown() {
        extent.flush();
    }
}
