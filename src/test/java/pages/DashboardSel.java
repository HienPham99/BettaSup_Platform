package pages;

import static keywords.WebUI.*;
import org.openqa.selenium.By;

public class DashboardSel {

    private String contentItemDashboardExpected="Dashboard";
    public static By menuTotal = By.xpath("//ul[@class='ant-menu ant-menu-root ant-menu-inline ant-menu-light w-full !outline-none h-full css-p9crew']");
    public static By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public static By menuRFQ = By.xpath("//span[normalize-space()='RFQ']");
    private By menuProduct = By.xpath("//span[normalize-space()='Product']");
    private By menuOrder = By.xpath("//span[normalize-space()='Order']");
    private By menuMyBalance = By.xpath("//span[normalize-space()='My balance']");
    private By menuSetting = By.xpath("//span[normalize-space()='Setting']");

    private By dropdownProfile = By.xpath("//p[@id='dashboard']/following-sibling::div//p");
    private By optionLogout = By.xpath("//button[normalize-space()='Logout']");


    public RFQSelPage clickMenuRFQSel() {
        clickElement(menuRFQ);
        waitForPageLoaded();
        return new RFQSelPage();
    }

    public LoginSelPage logout() {
        clickElement(dropdownProfile);
        clickElement(optionLogout);
        waitForPageLoaded();
        return new LoginSelPage();
    }
}

