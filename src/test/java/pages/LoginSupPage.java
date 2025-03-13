package pages;

import helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.LogUtils;

import static helpers.PropertiesHelper.getValue;
import static keywords.WebUI.*;

public class LoginSupPage {

    private String itemDashboardSupExpected = "Dashboard";

    //Location of Supplier_BS
    private By inputEmailBSup = By.id("login_email");
    private By inputPasswordBsSup = By.id("login_password");
    private By buttonLoginBsSup = By.xpath("//button[@type='submit']");


    public DashboardSup loginSuccessSup() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "bettaSup");
        loginBSSup(
                excelHelper.getCellData("EMAIL", 2),
                excelHelper.getCellData("PASSWORD", 2)
        );
        return new DashboardSup();
    }

    private void setEmailSup(String email) {
        setText(inputEmailBSup, email);
    }

    private void setPasswordSup(String password) {
        setText(inputPasswordBsSup, password);
    }

    private void clickButtonLoginSup() {
        clickElement(buttonLoginBsSup);
        waitForPageLoaded();
    }

    public void verifyLoginSupSuccess() {
        waitForPageLoaded();
        // Assert.assertFalse(getDriver().getCurrentUrl().contains("dashboard"), "\uD83E\uDD40Login Unsuccessful. Vẫn ở trang login page.");
        assertEquals(getElementText(DashboardSel.menuDashboard), itemDashboardSupExpected, "Content menu Dashboard page NOT match.");
        LogUtils.info("Section của Supplier:\n" + getElementText(DashboardSel.menuTotal));
        LogUtils.info("*************************");
    }

    public DashboardSup loginBSSup(String email, String password) {
        opeURL(getValue("url_Supplier"));
        waitForPageLoaded();
        setEmailSup(email);
        setPasswordSup(password);
        clickButtonLoginSup();
        return new DashboardSup();
    }

}
