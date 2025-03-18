package pages;

import helpers.ExcelHelper;
import org.openqa.selenium.By;
import utils.LogUtils;

import static helpers.PropertiesHelper.getValue;
import static keywords.WebUI.*;

public class LoginBTMStorePage {

    private String itemDashboardSelerExpected = "Dashboard";

    //Location
    private By inputEmailBsSel = By.id("login_email");
    private By inputPasswordBsSel = By.id("login_password");
    private By buttonLoginBsSel = By.xpath("//button[@type='submit']");


    public DashboardSel loginSuccessSel() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "bettaMax");
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
        assertEquals(getElementText(DashboardSel.menuDashboard), itemDashboardSelerExpected, "Content menu Dashboard page NOT match.");
        LogUtils.info("Section của of Seller:\n" + getElementText(DashboardSel.menuTotal));
        LogUtils.info("*************************");
    }

    public DashboardSel loginBSSel(String email, String password) {
        opeURL(getValue("url_adminStoreBM"));
        waitForPageLoaded();
        setEmailSel(email);
        setPasswordSel(password);
        clickButtonLoginSel();
        return new DashboardSel();
    }

}
