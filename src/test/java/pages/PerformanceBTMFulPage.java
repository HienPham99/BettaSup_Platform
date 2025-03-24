package pages;

import org.openqa.selenium.By;

import static keywords.WebUI.*;

public class PerformanceBTMFulPage {

    private String contentItemDashboardExpected="Performance";

    public static By menuPerformance = By.xpath("//div[@id='performance']");
    private By iconLogout= By.id("radix-:rc:");
    private By buttonLogout = By.id("radix-:rd:");
    private By menuProductFF = By.id("product");
    private By subMenuCatalog= By.id("product-catalog");


    public ProductFFPage clickMenuProductFF() {
        waitForPageLoaded();
        clickElement(menuProductFF);
        sleep(1);
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

