package pages;

import org.openqa.selenium.By;

import static keywords.WebUI.*;

public class SelectStorePage {

    private By storeName = By.xpath("//div[@id='label-select-store']/parent::div/following-sibling::div");

//    public void verifySelectStoreSuccess() {
//        waitForPageLoaded();
//        //Assert.assertFalse(getDriver().getCurrentUrl().contains("dashboard"), "\uD83E\uDD40Login Unsuccessful. Vẫn ở trang login page.");
//        //assertEquals(getElementText(DashboardSel.menuDashboard), itemDashboardSelerExpected, "Content menu Dashboard page NOT match.");
//        LogUtils.info("Section của of Seller:\n" + getElementText(DashboardSel.menuTotal));
//        LogUtils.info("*************************");
//    }

    public HomeBTMStorePage nagigateHomeBTMStore() {
        sleep(3);
        clickElement(storeName);
        waitForPageLoaded();
        return new HomeBTMStorePage();
    }

}

