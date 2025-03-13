package testcases;

import common.BaseTest;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

@Listeners(TestListener.class)
public class RFQTest extends BaseTest {
    LoginSelPage loginSelPage;
    LoginSupPage loginSupPage;
    DashboardSel dashboardSelPage;
    DashboardSup dashboardSupPage;
    RFQSelPage rfqSelPage;
    RFQSupPage rfqSupPage;

    @Test(priority = 1, description = "\uD83D\uDCE2TC01_Verify Login Seller Success.")
    public void verifyPostNewRequestSuccess() {
        loginSelPage = new LoginSelPage();
        dashboardSelPage = new DashboardSel();
        rfqSelPage = new RFQSelPage();
        dashboardSelPage = loginSelPage.loginSuccessSel();
        rfqSelPage = dashboardSelPage.clickMenuRFQSel();
        rfqSelPage.verifyHeaderRFQSelPage();
        rfqSelPage.verifyTabsItemRFQ();
        rfqSelPage.verifyListItemRFQSel();
        rfqSelPage.clickButtonPostNewRequest();
        rfqSelPage.verifyFormPostYourRequest();
        rfqSelPage.inputInforRequest();
        rfqSelPage.searchRequest();
        rfqSelPage.verifyRequestDetail();
    }
}
