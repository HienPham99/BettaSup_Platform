package pages;

import helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utils.LogUtils;

import static keywords.WebUI.*;

public class ProductPage {
    private By iconSearch = By.id("search-product");
    private By firstItem = By.xpath("//table//tbody//tr[2]//td[1]//p");

    public void searchProduct() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        setText(iconSearch, excelHelper.getCellData("PRODUCT_NAME", 1));
    }

    public void verifyProductAcceptSuccess() {
        waitForPageLoaded();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getElementText(firstItem), excelHelper.getCellData("PRODUCT_NAME", 1), "Product name NOT match.");
        sleep(1);
        LogUtils.info("##################################");
    }

}
