package nopcommercedataproviders;

import base.CommonAPI;
import org.testng.annotations.DataProvider;
import utility.ExcelReader;

public class NOPTestData extends CommonAPI {

    @DataProvider(name = "testdata")
    public Object[][] computerOptions() {
        new ExcelReader("C:\\Users\\MSI - Laptop\\Downloads\\Computer.xlsx").getEntireColumnForGivenHeader("Sheet1", "ComputerOption");
            Object[][] computer = new Object[2][2];
            computer[0][0] = "";
            computer[0][1] = "";
            computer[1][0] = "";
            computer[1][1] = "";
        return computer;
        }
    }
}

