package pages;

import org.openqa.selenium.By;

import static keywords.WebUI.clickElement;
import static keywords.WebUI.waitForPageLoaded;

public class HomeBTMStorePage {

    private By menuProduct = By.id("product");
    private By subMenuMyProduct= By.id("my-product");
    private By iconLogout= By.id("radix-:rc:");
    private By buttonLogout = By.id("radix-:ri:");
    private By buttonLogoutStore = By.xpath("//div[contains(text(),'Logout')]");



    public ProductStorePage clickMenuProduct() {
        clickElement(menuProduct);
        clickElement(subMenuMyProduct);
        waitForPageLoaded();
        return new ProductStorePage();
    }

    public SelectStorePage logout() {
        clickElement(iconLogout);
        clickElement(buttonLogout);
        waitForPageLoaded();
        return new SelectStorePage();
    }

   }

