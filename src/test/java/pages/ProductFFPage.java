package pages;

import helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utils.LogUtils;

import static keywords.WebUI.*;

public class ProductFFPage {

    private By iconSearch = By.id("input-search-product");
    private By checkboxFirstItem = By.xpath("/html/body/main/div/main/div[2]/div[2]/div/div[1]/div/div/div[1]/div[1]/div/div[1]/div[1]/div/button");
    private By formSelectProduct = By.id("selected-product-actions");
    private By buttonAddToStore= By.id("button-add-to-store");
    private By inputSearchStore = By.xpath("(//label[normalize-space()='Add Product to Store']/parent::div/following-sibling::div//input)[1]");
    private By iconAddStoreItem = By.xpath("//button[@id='add-store-item']");
    private By buttonAddStore = By.xpath("//button[@id='add-store']");



    public void searchProductCatalog() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        setText(iconSearch, excelHelper.getCellData("PRODUCT_NAME", 1));
    }

    public void verifyFormActiveProduct(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementExist(formSelectProduct), "Form active product NOT exist.");
        softAssert.assertTrue(checkElementDisplayed(formSelectProduct),"Form active product NOT displayed.");
        softAssert.assertAll();
    }

    public void addProductToStore(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "bettaMax");
        waitForPageLoaded();
        clickElement(checkboxFirstItem);
        verifyFormActiveProduct();
        clickElement(buttonAddToStore);
        sleep(1);
        setText(inputSearchStore, excelHelper.getCellData("STORE_NAME", 1));
        clickElement(iconAddStoreItem);
        clickElement(buttonAddStore);
        waitForPageLoaded();
    }

}
