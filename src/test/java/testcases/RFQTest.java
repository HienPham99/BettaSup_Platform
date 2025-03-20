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
    LoginBTMFFPage loginBTMFFPage;
    LoginBTMStorePage loginBTMStorePage;
    DashboardSel dashboardSelPage;
    DashboardSup dashboardSupPage;
    HomeBTMStorePage homeBTMStorePage;
    PerformanceBTMFulPage performanceBTMFulPage;
    RFQSelPage rfqSelPage;
    RFQSupPage rfqSupPage;
    ProductPage productPage;
    ProductStorePage productStorePage;
    ProductFFPage productFFPage;

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

    @Test(priority = 3, description = "\uD83D\uDCE2TC03_Verify add product from Fulfill to Store success.")
    public void verifyAddProductToStoreSuccess() {
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

    @Test(priority = 4, description = "\uD83D\uDCE2TC04_Verify active product success.")
    public void verifyActiveProductSuccess() {
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
