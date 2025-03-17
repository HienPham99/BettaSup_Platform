package pages;

import static helpers.PropertiesHelper.*;

import helpers.ExcelHelper;

import static keywords.WebUI.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.LogUtils;

public class LoginSelPage {

    private String itemDashboardSelerExpected = "Dashboard";
    //private String itemDashboardSupplierExpected = "Dashboard";

    //Location of Seller_BS
    private By inputEmailBsSel = By.id("login_email");
    private By inputPasswordBsSel = By.id("login_password");
    private By buttonLoginBsSel = By.xpath("//button[@type='submit']");

    //Location of Supplier_BS
//    private By inputEmailBSup = By.id("login_email");
//    private By inputPasswordBsSup = By.id("login_password");
//    private By buttonLoginBsSup = By.xpath("//button[@type='submit']");


    public DashboardSel loginSuccessSel() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "bettaSup");
        loginBSSel(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        return new DashboardSel();
    }

    private void setEmailSel(String email) {
        setText(inputEmailBsSel, email);
    }

    private void setPasswordSel(String password) {
        setText(inputPasswordBsSel, password);
    }

    private void clickButtonLoginSel() {
        clickElement(buttonLoginBsSel);
        waitForPageLoaded();
    }

    public void verifyLoginSelSuccess() {
        waitForPageLoaded();
        //Assert.assertFalse(getDriver().getCurrentUrl().contains("dashboard"), "\uD83E\uDD40Login Unsuccessful. Vẫn ở trang login page.");
        assertEquals(getElementText(DashboardSel.menuDashboard), itemDashboardSelerExpected, "Content menu Dashboard page NOT match.");
        LogUtils.info("Section của of Seller:\n" + getElementText(DashboardSel.menuTotal));
        LogUtils.info("*************************");
    }

    public DashboardSel loginBSSel(String email, String password) {
        opeURL(getValue("url_Seller"));
        waitForPageLoaded();
        setEmailSel(email);
        setPasswordSel(password);
        clickButtonLoginSel();
        return new DashboardSel();
    }

}
