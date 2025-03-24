package pages;

import helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utils.LogUtils;

import static keywords.WebUI.*;

public class ProductFFPage {
    private String msgExxpected = "Add to store successfully";

    private By iconSearch = By.id("input-search-product");
    private By firstItem = By.xpath("/html/body/main/div/main/div[2]/div[2]/div/div[1]/div/div/div[1]/div[1]/div/div");
    private By checkboxFirstItem = By.xpath("/html/body/main/div/main/div[2]/div[2]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[1]/div/button");
    private By formSelectProduct = By.id("selected-product-actions");
    private By buttonAddToStoreForm = By.id("button-add-to-store");
    private By inputSearchStore = By.xpath("(//label[normalize-space()='Add Product to Store']/parent::div/following-sibling::div//input)[1]");
    private By iconAddStoreItem = By.id("add-store-item");
    private By buttonAddStore = By.id("add-store");
    private By msgAddProductToStoreSuccess = By.xpath("/html/body/div/div/div/div/div/div/div[2]");


    public void searchProductCatalog() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        setText(iconSearch, excelHelper.getCellData("PRODUCT_NAME", 2));
    }

    public void verifyProductDisplayOnProductList() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementDisplayed(firstItem), "\uD83D\uDC1EProduct Name NOT display on product list. ");
        sleep(2);
        softAssert.assertAll();
    }

    public void verifyFormActiveProduct() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementExist(formSelectProduct), "Form active product NOT exist.");
        softAssert.assertTrue(checkElementDisplayed(formSelectProduct), "Form active product NOT displayed.");
        softAssert.assertAll();
    }

    public void addProductToStore() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "bettaMax");
        waitForPageLoaded();
        clickElement(checkboxFirstItem);
        sleep(2);
        clickElement(buttonAddToStoreForm);
        sleep(2);
        setText(inputSearchStore, excelHelper.getCellData("STORE_NAME", 1));
        clickElement(iconAddStoreItem);
        sleep(2);
        clickElement(buttonAddStore);
           }

    public void verifyAddProductToStoreSuccess(){
        //waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertTrue(checkElementExist(msgAddProductToStoreSuccess), "Message add product to store NOT exist.");
        //softAssert.assertTrue(checkElementDisplayed(msgAddProductToStoreSuccess),"Message add product to store NOT displayed.");
        softAssert.assertEquals(getElementText(msgAddProductToStoreSuccess), msgExxpected, "Message add product to store NOT match.");
        LogUtils.info("Content actual of msg add product to store: " + getElementText(msgAddProductToStoreSuccess));
        softAssert.assertAll();
    }


}
