import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.ExtentReportConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.example.Config.URL;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class testGETRequest extends BaseTest{
    private ExtentTest test;

    @Test
    public void testApiWithGET() {
        test = extent.createTest("testApiWithGET");

        RestAssured.baseURI = URL;

        Response response = given()
                .param("page", 2)
                .when()
                .get("/users");


        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "Unexpected status code");

        String contentType = response.getHeader("Content-Type");
        assertEquals(contentType, "application/json; charset=utf-8", "Unexpected content-type");



        int perPageValue = response.jsonPath().getInt("per_page");
        int numberOfUsersOnPage = response.jsonPath().getList("data").size();
        assertEquals(perPageValue, numberOfUsersOnPage, "per_page value doesn't match the number of users on the page");


        response.jsonPath().getList("data.email").forEach(email -> assertTrue("Email domain extension is not reqres.in", email.toString().endsWith("@reqres.in")));


        response.jsonPath().getList("data.id").forEach(id -> {
            int idValue = Integer.parseInt(id.toString());
            assertTrue("ID value is not within the range of 5-15", idValue >= 5 && idValue <= 15);
        });


        int totalUsers = response.jsonPath().getInt("total");
        assertEquals(totalUsers, 12, "Unexpected number of users on page 2");


        String userName = response.jsonPath().getString("data[0].first_name");
        assertEquals(userName, "Michael", "Unexpected user name");

    }

}

