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
    ProductPage productPage;

    @Test(priority = 1, description = "\uD83D\uDCE2TC01_Verify Post new request form Seller success.")
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

    @Test(priority = 2, description = "\uD83D\uDCE2TC02_Verify Create new quote form Supplier success.")
    public void verifyCreateNewQuoteSuccess() {
        loginSupPage = new LoginSupPage();
        dashboardSupPage = new DashboardSup();
        rfqSupPage = new RFQSupPage();
        dashboardSupPage = loginSupPage.loginSuccessSup();
        rfqSupPage = dashboardSupPage.clickMenuRFQSup();
        rfqSupPage.verifyHeaderRFQSupPage();
        rfqSupPage.verifyTabsItemRFQ();
        rfqSupPage.verifyListItemRFQSup();
        rfqSupPage.searchRFQ();
        rfqSupPage.clickQuoteNow();
        rfqSupPage.verifyFormCreateNewQuote();
        rfqSupPage.inputChooseProduct();
        rfqSupPage.selectProductSuggest();
        rfqSupPage.verifyAfterCreateQuoteSuccess();

    }
}
