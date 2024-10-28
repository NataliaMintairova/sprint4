package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiePage {
    private WebDriver driver;

    private By closeCookieButton = By.xpath(".//button[text()='да все привыкли']");

public CookiePage(WebDriver driver){
    this.driver = driver;
}
public void clickCookieButton(){
    driver.findElement(closeCookieButton).click();
}

}
