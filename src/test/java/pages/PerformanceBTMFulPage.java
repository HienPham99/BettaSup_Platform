package pages;

import org.openqa.selenium.By;

import static keywords.WebUI.clickElement;
import static keywords.WebUI.waitForPageLoaded;

public class PerformanceBTMFulPage {

    private String contentItemDashboardExpected="Performance";

    public static By menuPerformance = By.xpath("//div[@id='performance']");
    private By iconLogout= By.id("radix-:rc:");
    private By buttonLogout = By.id("radix-:rd:");
    private By menuProductFF = By.id("id='radix-:r4:");
    private By subMenuCatalog= By.id("product-catalog");


    public ProductFFPage clickMenuProductFF() {
        clickElement(menuProductFF);
        clickElement(subMenuCatalog);
        waitForPageLoaded();
        return new ProductFFPage();
    }

    public LoginBTMFFPage logout() {
        clickElement(iconLogout);
        clickElement(buttonLogout);
        waitForPageLoaded();
        return new LoginBTMFFPage();
    }
}

