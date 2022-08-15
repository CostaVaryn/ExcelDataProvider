import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest {

    @Test(dataProvider = "usersFromSheet1", dataProviderClass = ExcelDataProviders.class)
    public void test(String... params){
        System.out.println("User " + params[1] + " has ID number " + params[0] + " surname " + params[2]);
    }

    @Test(dataProvider = "usersFromSheet2", dataProviderClass = ExcelDataProviders.class)
    public void test2(String params1, String params2){
        System.out.println("Login: " + params1);
        System.out.println("Password: " + params2);
    }

    /**
     * @DataProvider
     * public Object[][] data(){
     *      return new Object[][]{
     *          {"Adam"},
     *          {"Mark"},
     *          {"Petr"}
     *      };
     * }
     */
}
