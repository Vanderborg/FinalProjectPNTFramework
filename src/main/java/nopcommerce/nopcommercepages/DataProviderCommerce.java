package nopcommerce.nopcommercepages;

import nopcommerce.nopcommerceenums.creditcard.CC;
import nopcommerce.nopcommerceenums.excel.Excel;
import org.testng.annotations.DataProvider;
import utility.ConnectDB;
import utility.ExcelReader;

public class DataProviderCommerce {

    public final static String LoginData = "LoginDataProver";

    public final static String CreditData = "CreditData";

    @DataProvider(name = LoginData)
    public Object[][] getLoginData() {
        String passwordData = new ExcelReader(Excel.CC_PATH.getExcel()).getDataFromCell(Excel.SHEET.getExcel(), 1, 1);
        return new Object[][]{{passwordData}};
    }

    @DataProvider(name = CreditData)
    public Object[][] getCCData() {
        String ccData = new ConnectDB().readMysqlDataBaseColumn(CC.CC_TABLE.getCcCredentials(), CC.CC_NUMBER.getCcCredentials()).toString().replace("[", "").replace("]", "");
        String ccDataCode = new ConnectDB().readMysqlDataBaseColumn(CC.CC_TABLE.getCcCredentials(), CC.CC_CODE.getCcCredentials()).toString().replace("[", "");
        return new Object[][]{{ccData, ccDataCode}};
    }
}
