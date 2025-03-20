package pages;

import helpers.ExcelHelper;
import org.openqa.selenium.By;
import utils.LogUtils;

import static helpers.PropertiesHelper.getValue;
import static keywords.WebUI.*;

public class LoginBTMStorePage {

     //Location of Admin Store
    private By inputEmailStore = By.id("input-email");
    private By inputPasswordStore = By.id("input-password");
    private By buttonLoginStore = By.id("button-login");
   // private By storeName = By.xpath("//div[@id='label-select-store']/parent::div/following-sibling::div");

    public SelectStorePage inputLoginSuccessStore() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "bettaMax");
        loginBTMStore(
                excelHelper.getCellData("EMAIL", 1),
                excelHelper.getCellData("PASSWORD", 1)
        );
        return new SelectStorePage();
    }

    private void setEmail(String email) {
        setText(inputEmailStore, email);
    }

    private void setPassword(String password) {
        setText(inputPasswordStore, password);
    }

    private void clickButtonLogin() {
        clickElement(buttonLoginStore);
        waitForPageLoaded();
    }


    public SelectStorePage loginBTMStore(String email, String password) {
        opeURL(getValue("url_adminStoreBM"));
        waitForPageLoaded();
        setEmail(email);
        setPassword(password);
        clickButtonLogin();
        sleep(2);
        return new SelectStorePage();
    }


}
