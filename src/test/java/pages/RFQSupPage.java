package pages;

import org.openqa.selenium.By;

public class RFQSupPage {

    private String headerRFQPageExpected = "Request For Quotation";

    private By headerRFQPage = By.id("request-for-quotation");
    private By inputSearch = By.id("input-search");

    private By buttonPostNewRequest = By.id("btn-post-new-request");
    private By labelFormPostNewRequest = By.id("post-your-request");
    private By formPostNewRequest = By.xpath("//form[@id='basic']");
    private By buttonCancel = By.xpath("//span[normalize-space()='Cancel']");
    private By buttonCreate = By.xpath("//span[normalize-space()='Create']");
    private By buttonGetInfomation = By.xpath("//span[contains(text(),'Get information')]");
    private By texboxGetinfomation = By.id("get-information");

    private By textboxProductName = By.xpath("//input[@id='basic_productName']");
    private By productImage = By.id("basic_productImage");
    private By msgGetInfoSuccess = By.xpath("//div[@role='alert']"); //msg show sau khi get infomation product
    private By popupPostRequestSel = By.xpath("//div[@class='ant-modal-content']");
    private By buttonConfirm = By.xpath("//span[normalize-space()='Confirm']");
    private By msgPostRequestSuccess = By.id("PING_IFRAME_FORM_DETECTION");

//    private By abc = By.xpath("");
//    private By abc = By.xpath("");
//    private By abc = By.xpath("");
//    private By abc = By.xpath("");
//    private By abc = By.xpath("");
//    private By abc = By.xpath("");
//    private By abc = By.xpath("");


//    public DashboardSup postRequestSuccess() {
//        ExcelHelper excelHelper = new ExcelHelper();
//        excelHelper.setExcelFile("src/test/resources/testdata/DataLogin.xlsx", "dataProductlink");
//        WebUI.setText(
//                excelHelper.getCellData("PRODUCTLINK", 1)
//        );
//        return new DashboardSup();
//    }

}
