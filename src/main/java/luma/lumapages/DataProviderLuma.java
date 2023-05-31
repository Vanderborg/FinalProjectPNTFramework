package luma.lumapages;

import org.testng.annotations.DataProvider;
import utility.ExcelReader;

public class DataProviderLuma {

    @DataProvider(name = "Login")
    public Object[][] getLoginData() {
        String email = new ExcelReader("C:\\Users\\acekn\\Downloads\\DataProvider.xlsx").getDataFromCell("Sheet1", 1, 0);
        String password = new ExcelReader("C:\\Users\\acekn\\Downloads\\DataProvider.xlsx").getDataFromCell("Sheet1", 1, 1);
        return new Object[][]{{email, password}};
    }
}
