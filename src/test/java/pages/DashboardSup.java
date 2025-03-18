package pages;

import org.openqa.selenium.By;

import static keywords.WebUI.clickElement;
import static keywords.WebUI.waitForPageLoaded;

public class DashboardSup {

    private String contentItemDashboardExpected="Dashboard";
    public static By menuDashboardTotal = By.xpath("//li[@id='menu-item-dashboard']/parent::ul");
    public static By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public static By menuRFQ = By.id("menu-item-rfq");
    private By menuProduct = By.id("menu-item-product");
    private By menuOrder = By.id("menu-item-order");
    private By menuMyBalance = By.id("menu-item-my-balance");

    private By dropdownProfile = By.id("user-email");
   private By optionLogout = By.xpath("//button[normalize-space()='Logout']");


    public RFQSupPage clickMenuRFQSup() {
        clickElement(menuRFQ);
        waitForPageLoaded();
        return new RFQSupPage();
    }

    public ProductPage clickMenuProduct() {
        clickElement(menuProduct);
        waitForPageLoaded();
        return new ProductPage();
    }

    public LoginSupPage logout() {
        clickElement(dropdownProfile);
        clickElement(optionLogout);
        waitForPageLoaded();
        return new LoginSupPage();
    }
}

