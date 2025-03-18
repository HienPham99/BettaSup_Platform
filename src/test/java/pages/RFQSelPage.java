package pages;

import helpers.ExcelHelper;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.LogUtils;

import static helpers.PropertiesHelper.getValue;
import static keywords.WebUI.*;
import static keywords.WebUI.checkElementDisplayed;

public class RFQSelPage {

    private String headerRFQPageExpected = "Request For Quotation";

    private By headerRFQSelPage = By.id("request-for-quotation");
    private By inputSearch = By.id("input-search");
    private By subTabRFQ = By.xpath("//div[@class='ant-tabs-nav-list']");
    private By tabsItem = By.xpath("//div[contains(text(),'All' )]/ancestor::div[contains(@class,'ant-tabs-nav-list')]");
    private By tabAll = By.xpath("//div[contains(text(),'All')]");
    private By listItemRFQ = By.xpath("(//table//tbody)[2]");

    private By buttonPostNewRequest = By.id("btn-post-new-request");
    private By labelFormPostNewRequest = By.id("post-your-request");
    private By formPostNewRequest = By.xpath("//form[@id='basic']");
    private By buttonCancel = By.xpath("//span[normalize-space()='Cancel']");
    private By buttonCreate = By.xpath("//span[normalize-space()='Create']");
    private By buttonGetInfomation = By.xpath("//span[contains(text(),'Get information')]");
    private By inputGetinfomation = By.id("get-information");

    private By textboxProductName = By.xpath("//input[@id='basic_productName']");
    private By productNamePortNewRequest = By.xpath("//input[@id='basic_productName']");
    private By productImage = By.id("basic_productImage");
    private By msgGetInfoSuccess = By.xpath("//div[@role='alert']"); //msg show sau khi get infomation product
    private By popupPostRequestSel = By.xpath("//div[@class='ant-modal-content']");
    private By buttonConfirm = By.xpath("//span[normalize-space()='Confirm']");
    private By msgPostRequestSuccess = By.id("PING_IFRAME_FORM_DETECTION");
    private By fistItemRequest = By.xpath("(//table//tbody//tr[2]//td)[1]");
    private By labelRequestDetail = By.id("detail-request");
    private By formDetaiSellerRequest = By.xpath("//p[@id='detail-request']/following::div[3]");
    private By productName = By.xpath("//div[normalize-space()='Seller request']/following-sibling::div//div[contains(@class,'text-textMD font-semibold line-clamp-1')]");
    private By buttonQuotedRequestDetail = By.xpath("//div[normalize-space()='Received quotes']/following-sibling::div//span[normalize-space()='Quoted']");
    private By buttonAccept= By.xpath("//span[normalize-space()='Accept & Import to My product']");
    private By msgImportProductSuccess= By.xpath("//div[@role='alert']");
    private By buttonViewInMyProduct = By.xpath("//span[normalize-space()='View in My product']");

    public void verifyHeaderRFQSelPage() {
        SoftAssert softAssert = new SoftAssert();
        waitForPageLoaded();
        waitForElementVisible(headerRFQSelPage);
        softAssert.assertTrue(checkElementDisplayed(headerRFQSelPage), "Header RFQ Seller NOT displayed");
        softAssert.assertEquals(getElementText(headerRFQSelPage), headerRFQPageExpected, "Header RFQ Seller page NOT match.");
        LogUtils.info("\uD83C\uDF81Actual Header của RFQ Seller page là: " + getElementText(headerRFQSelPage));
        LogUtils.info("☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️");
        softAssert.assertAll();
    }

    public void verifyTabsItemRFQ() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementDisplayed(tabsItem), "Tabs item not display");
        LogUtils.info("Tabs item RFQ của Seller:\n" + getElementText(tabsItem));
    }

    public void verifyListItemRFQSel() {
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(listItemRFQ), "List Item NOT exists");
        Assert.assertTrue(checkElementDisplayed(listItemRFQ), "List Item NOT displayed");
        LogUtils.info("\uD83E\uDD29List Item in RFQ page is: " + getElementText(listItemRFQ));
    }

    public void clickButtonPostNewRequest() {
        clickElement(buttonPostNewRequest);
        waitForPageLoaded();
    }

    public void verifyFormPostYourRequest() {
        waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementDisplayed(formPostNewRequest), "Label form not display");
        softAssert.assertAll();
    }

    public void inputInforRequest() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        setText(inputGetinfomation, excelHelper.getCellData("PRODUCT", 1));
        sleep(1);
        clickElement(buttonGetInfomation);
        sleep(2);
        clickElement(buttonCreate);
        clickElement(buttonConfirm);
        waitForPageLoaded();
    }

    //Viết hàm search request name sau ki post success
    public void searchRequest() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        clickElement(tabAll);
        sleep(1);
        setText(inputSearch, excelHelper.getCellData("PRODUCT_NAME", 1));
        clickElement(fistItemRequest);
        waitForPageLoaded();
    }

    public void verifyRequestDetail() {
        SoftAssert softAssert = new SoftAssert();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        softAssert.assertTrue(checkElementDisplayed(formDetaiSellerRequest), " ");
        softAssert.assertEquals(getElementText(productName), excelHelper.getCellData("PRODUCT_NAME", 1), "Product name NOT match.");
        sleep(1);
        softAssert.assertAll();
    }

    public void acceptQuoteSuccess(){
        clickElement(fistItemRequest);
        sleep(2);
        clickElement(buttonQuotedRequestDetail);
        waitForPageLoaded();
        clickElement(buttonAccept);
        sleep(1);
        verifyImportProductSuccess();
    }
    public void verifyImportProductSuccess(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementDisplayed(msgImportProductSuccess), "Msg NOT display");
        LogUtils.info("Msg Import product success: "+ getElementText(msgImportProductSuccess));
        waitForPageLoaded();
    }
    public ProductPage clickViewInMyProduct(){
        clickElement(buttonViewInMyProduct);
        waitForPageLoaded();
        return new ProductPage();
    }
}
