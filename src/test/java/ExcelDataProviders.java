import org.testng.annotations.DataProvider;


public class ExcelDataProviders {

    @DataProvider
    public Object[][] usersFromSheet1() throws Exception {
        String path = "src/main/resources/users.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        return excelReader.getSheetDataForTDD();
    }

    @DataProvider
    public Object[][] usersFromSheet2() throws Exception {
        String path = "src/main/resources/users.xlsx";
        ExcelReader excelReader = new ExcelReader(path,"Лист2");
        return excelReader.getCustomSheetForTDD();
    }

    @DataProvider
    public Object[][] usersFromApi() throws Exception {
        String path = "src/main/resources/usersForReqres.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        return excelReader.getSheetDataForTDD();
    }
}
