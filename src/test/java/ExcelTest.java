import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExcelTest {

    @Test(dataProvider = "usersFromSheet1", dataProviderClass = ExcelDataProviders.class)
    public void test(String... params) {
        System.out.println("User " + params[1] + " has ID number " + params[0] + " surname " + params[2]);
    }

    @Test(dataProvider = "usersFromSheet2", dataProviderClass = ExcelDataProviders.class)
    public void test2(String params1, String params2) {
        System.out.println("Login: " + params1);
        System.out.println("Password: " + params2);
    }

    @Test(dataProvider = "usersFromApi", dataProviderClass = ExcelDataProviders.class)
    public void checkUsers(String... params) {
        int id = (int) Double.parseDouble(params[0]);
        Response response = given().
                contentType(ContentType.JSON)
                .get("https://reqres.in/api/users/" + id)
                .then().log().body().extract().response();
        JsonPath jsonPath = response.jsonPath();
        // String email = jsonPath.getString("data.email");
        Assert.assertEquals(jsonPath.getInt("data.id"), id);
        Assert.assertEquals(jsonPath.getString("data.email"), params[1]);
        Assert.assertEquals(jsonPath.getString("data.first_name"), params[2]);
        Assert.assertEquals(jsonPath.getString("data.last_name"), params[3]);
        Assert.assertEquals(jsonPath.getString("data.avatar"), params[4]);
    }
    /**
     * @DataProvider
     * public Object[][] data() {
     *      return new Object[][] {
     *          {"Adam"},
     *          {"Mark"},
     *          {"Petr"}
     *      };
     * }
     */
}
