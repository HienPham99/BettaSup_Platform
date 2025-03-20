package pages;

import helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.LogUtils;

import static keywords.WebUI.*;
import static keywords.WebUI.getElementText;

public class RFQSupPage {

    private String headerRFQPageExpected = "Request For Quotation";

    private By headerRFQPage = By.xpath("//p[normalize-space()='Request For Quotation']");
    private By inputSearch = By.id("input-search");
    private By tabsItem = By.xpath("//input[@id='input-search']/following::div[contains(@class,'ant-tabs-nav-list')]");
    private By tabAll = By.xpath("//div[contains(text(),'All')]");
    private By tabQuoted = By.xpath("//div[contains(@id,'tab-quoted')]");
    private By rfqList = By.xpath("(//table/tbody)[2]");
    private By fistItemRFQ = By.xpath("(//table//tbody//tr[2]//td)[1]");
    private By itemProductAfter = By.xpath("(//table//tbody/tr[2]//td[1]//div[contains(@class,'line-clamp-2 text-textSM break-all')])[1]");
    private By buttonQuoteNow = By.xpath("//span[normalize-space()='Quote now']"); //((//table/tbody)[2]/tr/td)[10]");
    private By quoteForm = By.xpath("//p[@id='create-new-quote']/following::div[2]");
    private By labelQuoteForm = By.id("create-new-quote");
    private By buttonCancel = By.xpath("//span[normalize-space()='Cancel']");
    private By buttonCreateNewQuote = By.id("btn-create-quote");
    private By nameProduct = By.id("sellerProductName");
    private By inputChooseProduct = By.id("search-product-name");
    private By fistItemProductSuggest = By.xpath("(//input[@id='search-product-name']/parent::span/following-sibling::div//div)[1]/div[1]");
    private By formDefineProduct = By.xpath("//div[normalize-space()='Define product pricing']/following-sibling::div");

    private By buttonCreateNewProduct = By.id("create-new-product");
    private By formCreateNewProduct = By.xpath("//div[@id='information-product-box']/parent::div");
    private By inputProductName = By.xpath("//div[@id='product-name']//span//input");
    private By buttonUpload = By.xpath("//span[normalize-space()='Upload']/parent::button");
    private By textareaDescription = By.xpath("//div[@id='product-description']//div[contains(@role,'presentation')][2]");
    private By inputLength = By.id("length");
    private By inputWidth = By.id("width");
    private By inputHeight = By.id("height");
    private By inputWeight = By.id("weight");
    private By inputPropertyName = By.xpath("//div[@id='property-name']//input[@type='text']");
    private By inputPropertyValue = By.xpath("//div[@id='property-value']//input");
    private By buttonDone = By.id("btn-done");
    private By iconUploadImg = By.id("upload-button");
    private By inputPrice = By.id("input-price");

    private By popupCreateNewProduct = By.xpath("//button[@id='btn-create-product']/ancestor::div[contains(@class,'ant-modal-footer')]/preceding-sibling::div/parent::div");
    private By buttonCreateProduct = By.id("btn-create-product");
    private By msgCreateProductSuccess = By.xpath("//p[contains(text(),'Create product successfully. You can use this prod')]");

    private By inputProcessingTime = By.xpath("//div[@id='processing-time']//input");
    private By popupCreateQuote = By.xpath("//div[@id='modal-confirm-create-quote']/ancestor::div[contains(@class,'ant-modal-content')]");
    private By buttonCreateQuote = By.id("btn-confirm-create-quote");
    private By msgCreateQuoteSuccess = By.xpath("//span[@id='PING_IFRAME_FORM_DETECTION']");

    SoftAssert softAssert = new SoftAssert();

    public void verifyHeaderRFQSupPage() {
        //SoftAssert softAssert = new SoftAssert();
        waitForPageLoaded();
        waitForElementVisible(headerRFQPage);
        softAssert.assertTrue(checkElementDisplayed(headerRFQPage), "Header RFQ Supplier NOT displayed");
        softAssert.assertEquals(getElementText(headerRFQPage), headerRFQPageExpected, "Header RFQ Supplier page NOT match.");
        LogUtils.info("\uD83C\uDF81Actual header của RFQ Supplier page là: " + getElementText(headerRFQPage));
        LogUtils.info("☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️☘️");
        softAssert.assertAll();
    }

    public void verifyTabsItemRFQ() {
        //SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementDisplayed(tabsItem), "Tabs item not display");
        LogUtils.info("Tabs item RFQ của Supplier:\n" + getElementText(tabsItem));
    }

    public void verifyListItemRFQSup() {
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(rfqList), "ListItem NOT exists");
        Assert.assertTrue(checkElementDisplayed(rfqList), "ListItem NOT displayed");
        LogUtils.info("\uD83E\uDD29List Item in RFQ page is: " + getElementText(rfqList));
    }

    public void searchRFQ() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        clickElement(tabAll);
        sleep(1);
        setText(inputSearch, excelHelper.getCellData("PRODUCT_NAME", 1));
        sleep(3);
        waitForPageLoaded();
    }

    public void clickQuoteNow() {
        waitForPageLoaded();
        clickElement(fistItemRFQ);
        sleep(2);
        clickElement(buttonQuoteNow);
        //waitForPageLoaded();
    }

    public void verifyFormCreateNewQuote() {
        waitForPageLoaded();
        //SoftAssert softAssert = new SoftAssert();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        softAssert.assertTrue(checkElementDisplayed(labelQuoteForm), "Label form NOT display");
        softAssert.assertTrue(checkElementDisplayed(quoteForm), "Form 'Create new quote' NOT display");
        softAssert.assertEquals(getElementText(nameProduct), excelHelper.getCellData("PRODUCT_NAME", 1), "Product name NOT match.");
        sleep(1);
        softAssert.assertAll();
    }

    public void inputChooseProduct() {
        //setText(inputChooseProduct, "product");
        setText(inputChooseProduct, "Chang");
        sleep(1);
        verifyProductSuggest();
    }

    public void clickCreateNewProduct() {
        // SoftAssert softAssert = new SoftAssert();
        clickElement(buttonCreateNewProduct);
        waitForPageLoaded();
        softAssert.assertTrue(checkElementDisplayed(formCreateNewProduct), "Form Create new product NOT display");
        softAssert.assertAll();
    }

    public void verifyProductSuggest() {
        //SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementDisplayed(fistItemProductSuggest), " No product suggest");
        sleep(1);
        softAssert.assertAll();
    }

    public void verifyFormDefineProduct() {
        waitForPageLoaded();
        //SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementDisplayed(formDefineProduct), "Form define product NOT display");
        sleep(1);
        softAssert.assertAll();
    }

    public void verifyPopupCreateQuote() {
        softAssert.assertTrue(checkElementExist(popupCreateQuote), "Popup 'Are you sure to create this quotation?' Not exist.");
        softAssert.assertTrue(checkElementDisplayed(popupCreateQuote), "Popup create new quote NOT display.");
        softAssert.assertAll();
    }

    public void selectProductSuggest() {
        clickElement(fistItemProductSuggest);
        verifyFormDefineProduct();
        setText(inputProcessingTime, "2");
        clickElement(buttonCreateNewQuote);
        sleep(2);
        verifyPopupCreateQuote();
        clickElement(buttonCreateQuote);
        waitForPageLoaded();
    }

    public void verifyAfterCreateQuoteSuccess() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        setText(inputSearch, excelHelper.getCellData("PRODUCT_NAME", 1));
        clickElement(tabQuoted);
        //clickElement(itemProductAfter);
        //softAssert.assertEquals(getElementText(nameProduct), excelHelper.getCellData("PRODUCT_NAME", 1));
        softAssert.assertAll();
    }

//    public void inputCreateNewProduct() {
//        ExcelHelper excelHelper = new ExcelHelper();
//        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProduct");
//        setText(inputProductName, excelHelper.getCellData("PRODUCT_NAME", 1));
//        sleep(1);
//        //Viết hàm upload product IMG
//        setText(textareaDescription, excelHelper.getCellData("DESCRIPTION", 1));
//        setText(inputLength, excelHelper.getCellData("LENGTH", 1));
//        setText(inputWidth, excelHelper.getCellData("WIDTH", 1));
//        setText(inputHeight, excelHelper.getCellData("HEIGHT", 1));
//        setText(inputWeight, excelHelper.getCellData("WEIGHT", 1));
//        setText(inputPropertyName, excelHelper.getCellData("PROPERTY_NAME", 1));
//        setText(inputPropertyValue, excelHelper.getCellData("PROPERTY_VALUE", 1));
//        setKey(inputPropertyValue, Keys.ENTER);
//        sleep(1);
//        clickElement(buttonDone);
//        waitForPageLoaded();
//    }

//    public void createNewQuoteSucess() {
//        clickElement(buttonQuoteNow);
//        waitForPageLoaded();
//    }

}
