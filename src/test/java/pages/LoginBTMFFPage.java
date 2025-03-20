package pages;

import helpers.ExcelHelper;
import org.openqa.selenium.By;
import utils.LogUtils;

import static helpers.PropertiesHelper.getValue;
import static keywords.WebUI.*;

public class LoginBTMFFPage {

    //Location of Fulfillment
    private By inputEmailFul = By.id("email-input-login");
    private By inputPasswordFul = By.id("password-input-login");
    private By buttonLoginFul = By.id("button-login");

   // private By a = By.xpath("");



    public PerformanceBTMFulPage loginSuccessFul() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "bettaMax");
        loginBTMFul(
                excelHelper.getCellData("EMAIL", 2),
                excelHelper.getCellData("PASSWORD", 2)
        );
        return new PerformanceBTMFulPage();
    }

    private void setEmailSel(String email) {
        setText(inputEmailFul, email);
    }

    private void setPasswordSel(String password) {
        setText(inputPasswordFul, password);
    }

    private void clickButtonLoginFul() {
        clickElement(buttonLoginFul);
        waitForPageLoaded();
    }
//
//    public void verifyLoginFulSuccess() {
//        waitForPageLoaded();
//        //Assert.assertFalse(getDriver().getCurrentUrl().contains("dashboard"), "\uD83E\uDD40Login Unsuccessful. Vẫn ở trang login page.");
//        assertEquals(getElementText(DashboardSel.menuDashboard), itemDashboardSelerExpected, "Content menu Dashboard page NOT match.");
//        LogUtils.info("Section của of Seller:\n" + getElementText(DashboardSel.menuTotal));
//        LogUtils.info("*************************");
//    }

    public PerformanceBTMFulPage loginBTMFul(String email, String password) {
        opeURL(getValue("url_FulfillBM"));
        waitForPageLoaded();
        setEmailSel(email);
        setPasswordSel(password);
        clickButtonLoginFul();
        return new PerformanceBTMFulPage();
    }

}
