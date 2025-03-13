package testcases;

import common.BaseTest;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardSel;
import pages.DashboardSup;
import pages.LoginSelPage;
import pages.LoginSupPage;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
    LoginSelPage loginSelPage;
    DashboardSel dashboardSelPage;
    LoginSupPage loginSupPage;
    DashboardSup dashboardSupPage;

    @Test(priority = 1, description = "\uD83D\uDCE2TC01_Verify Login Seller Success.")
    public void verifyLoginSelSuccess() {
        loginSelPage = new LoginSelPage();
        dashboardSelPage = new DashboardSel();
        dashboardSelPage = loginSelPage.loginSuccessSel();
        loginSelPage.verifyLoginSelSuccess();
        dashboardSelPage.logout();
    }

    @Test(priority = 2, description = "\uD83D\uDCE2TC01_Verify Login Supplier Success.")
    public void verifyLoginSupSuccess() {
        loginSupPage = new LoginSupPage();
        dashboardSupPage = new DashboardSup();
        dashboardSupPage = loginSupPage.loginSuccessSup();
        loginSupPage.verifyLoginSupSuccess();
        dashboardSupPage.logout();
    }

}
