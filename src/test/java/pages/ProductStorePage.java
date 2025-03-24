package pages;

import helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utils.LogUtils;

import static keywords.WebUI.*;

public class ProductStorePage {

    private By labelMyProduct = By.id("title-product");
    private By inputSearch = By.id("input-search-product");
    private By firstItem = By.xpath("/html/body/main/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[1]/div[1]/div/div");
    private By checkboxProduct = By.xpath("//*[@id=\"check-box-product\"]");//"check-box-product");
    private By formSelectProduct = By.id("selected-products");
    private By buttonActive = By.id("active-button");
    private By buttonApply = By.xpath("(//div[@id='selected-products']/descendant::button)[3]");
    private By msgActiveProductSuccess = By.xpath("//label[normalize-space()='Set status active successfully!']");



    public void searchProduct() {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
        setText(inputSearch, excelHelper.getCellData("PRODUCT_NAME", 2));
    }
    public void verifyProductDisplayOnProductListStore() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementDisplayed(firstItem), "\uD83D\uDC1EProduct Name NOT display on product list STORE. ");
        sleep(2);
    }

    public void activeProduct(){
        waitForPageLoaded();
        clickElement(checkboxProduct);
        sleep(3);
       // verifyFormActiveProduct();
        clickElement(buttonActive);
        sleep(3);
        clickElement(buttonApply);
        sleep(3);
        //verifyActiveProductSuccess();
        }

    public void verifyFormActiveProduct(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementExist(formSelectProduct), "Form active product NOT exist.");
        softAssert.assertTrue(checkElementDisplayed(formSelectProduct),"Form active product NOT displayed.");
        softAssert.assertAll();
    }

    public void verifyActiveProductSuccess(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkElementExist(msgActiveProductSuccess), "Message active product success NOT exist.");
        softAssert.assertTrue(checkElementDisplayed(msgActiveProductSuccess),"Message active product success NOT displayed.");
        LogUtils.info("Content msg active product: " + getElementText(msgActiveProductSuccess));
        softAssert.assertAll();
    }


}
