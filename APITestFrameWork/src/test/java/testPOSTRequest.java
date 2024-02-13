import com.aventstack.extentreports.ExtentTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.ExcelDataReader;
import org.example.ExtentReportConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.example.Config.FILE_PATH;
import static org.example.Config.URL;
import static org.testng.Assert.assertEquals;

public class testPOSTRequest extends BaseTest {
    private static final String API_URL = "https://reqres.in/api/users";
    @DataProvider(name = "userData")
    public Object[][] getUserData() throws IOException {
        return ExcelDataReader.getUserData(FILE_PATH);
    }
    @Test(dataProvider = "userData")
    public void testApiWithPost(String name, String job) {
        ExtentTest test = extent.createTest("testApiWithPost - " + name);

        String requestBody = String.format("{\"name\": \"%s\", \"job\": \"%s\"}", name, job);


        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(API_URL);


        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 201, "Unexpected status code");

        String responseName = response.jsonPath().getString("name");
        String responseJob = response.jsonPath().getString("job");
        assertEquals(responseName, name, "Mismatch in name value between request and response");
        assertEquals(responseJob, job, "Mismatch in job value between request and response");

    }
}
