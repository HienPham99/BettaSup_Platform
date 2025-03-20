package testcases;

import common.BaseTest;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    LoginSelPage loginSelPage;
    LoginSupPage loginSupPage;
    LoginBTMFFPage loginBTMFFPage;
    LoginBTMStorePage loginBTMStorePage;
    DashboardSel dashboardSelPage;
    DashboardSup dashboardSupPage;
    PerformanceBTMFulPage performanceBTMFulPage;
    HomeBTMStorePage homeBTMStorePage;
    SelectStorePage selectStorePage;

    @Test(priority = 1, description = "\uD83D\uDCE2TC01_Verify Login Seller Success.")
    public void verifyLoginSelSuccess() {
        loginSelPage = new LoginSelPage();
        dashboardSelPage = new DashboardSel();
        dashboardSelPage = loginSelPage.loginSuccessSel();
        loginSelPage.verifyLoginSelSuccess();
        dashboardSelPage.logout();
    }

    @Test(priority = 2, description = "\uD83D\uDCE2TC02_Verify Login Supplier Success.")
    public void verifyLoginSupSuccess() {
        loginSupPage = new LoginSupPage();
        dashboardSupPage = new DashboardSup();
        dashboardSupPage = loginSupPage.loginSuccessSup();
        loginSupPage.verifyLoginSupSuccess();
        dashboardSupPage.logout();
    }

    @Test(priority = 3, description = "\uD83D\uDCE2TC03_Verify Login BTM Fulfil Success.")
    public void verifyLoginBTMFulSuccess() {
        loginBTMFFPage = new LoginBTMFFPage();
        performanceBTMFulPage = new PerformanceBTMFulPage();
        performanceBTMFulPage = loginBTMFFPage.loginSuccessFul();
        //performanceBTMFulPage.logout();
    }

    @Test(priority = 4, description = "\uD83D\uDCE2TC04_Verify Login BTM Store Success.")
    public void verifyLoginBTMStoreSuccess() {
        loginBTMStorePage = new LoginBTMStorePage();
        selectStorePage = new SelectStorePage();
        homeBTMStorePage = new HomeBTMStorePage();
        selectStorePage = loginBTMStorePage.inputLoginSuccessStore();
        homeBTMStorePage = selectStorePage.nagigateHomeBTMStore();
        homeBTMStorePage.logout();
    }

}
