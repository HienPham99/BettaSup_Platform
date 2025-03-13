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

//    public DashboardSup loginSuccessSup() {
//        ExcelHelper excelHelper = new ExcelHelper();
//        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "bettaSup");
//        loginBSSup(
//                excelHelper.getCellData("EMAIL", 2),
//                excelHelper.getCellData("PASSWORD", 2)
//        );
//        return new DashboardSup();
//    }

    private void setEmailSel(String email) {
        setText(inputEmailBsSel, email);
    }
//    private void setEmailSup(String email) {
//        setText(inputEmailBSup, email);
//    }

    private void setPasswordSel(String password) {
        setText(inputPasswordBsSel, password);
    }
//    private void setPasswordSup(String password) {
//        setText(inputPasswordBsSup, password);
//    }

    private void clickButtonLoginSel() {
        clickElement(buttonLoginBsSel);
        waitForPageLoaded();
    }
//    private void clickButtonLoginSup() {
//        clickElement(buttonLoginBsSup);
//        waitForPageLoaded();
//    }

    public void verifyLoginSelSuccess() {
        waitForPageLoaded();
        //Assert.assertFalse(getDriver().getCurrentUrl().contains("dashboard"), "\uD83E\uDD40Login Unsuccessful. Vẫn ở trang login page.");
        assertEquals(getElementText(DashboardSel.menuDashboard), itemDashboardSelerExpected, "Content menu Dashboard page NOT match.");
        LogUtils.info("Section của of Seller:\n" + getElementText(DashboardSel.menuTotal));
        LogUtils.info("*************************");
    }
//    public void verifyLoginSupSuccess() {
//        waitForPageLoaded();
//        Assert.assertFalse(getDriver().getCurrentUrl().contains("dashboard"), "\uD83E\uDD40Login Unsuccessful. Vẫn ở trang login page.");
//    }

    public DashboardSel loginBSSel(String email, String password) {
        opeURL(getValue("url_Seller"));
        waitForPageLoaded();
        setEmailSel(email);
        setPasswordSel(password);
        clickButtonLoginSel();
        return new DashboardSel();
    }

//    public DashboardSup loginBSSup(String email, String password) {
//        opeURL(getValue("url_Seller"));
//        waitForPageLoaded();
//        setEmailSup(email);
//        setPasswordSup(password);
//        clickButtonLoginSup();
//        return new DashboardSup();
//    }
}
