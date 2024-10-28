package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private WebDriver driver;

    private By inputName = By.xpath(".//input[@placeholder='* Имя']");
    private By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private By inputAddress = By.xpath(".//input[contains(@placeholder, '* Адрес')]");
    private By inputMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private By inputPhone = By.xpath(".//input[contains(@placeholder, '* Телефон')]");
    private By onwardsButton = By.xpath(".//button[contains(@class, 'Button_Middle')]");
    private By orderPage = By.xpath(".//div[contains(@class, 'App_App')]");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

        public void setInputName(String name){
        driver.findElement(inputName).sendKeys(name);
    }
        public void setInputSurname(String surname){
        driver.findElement(inputSurname).sendKeys(surname);
    }
        public void setInputAddress(String address){
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void clickInputMetroStation(){
        driver.findElement(inputMetroStation).click();
    }
       public void setInputPhone(String phone){
        driver.findElement(inputPhone).sendKeys(phone);
    }
    public void clickOnwardsButton(){
        driver.findElement(onwardsButton).isEnabled();
        driver.findElement(onwardsButton).click();
    }

    public void orderFirstWindow(String name, String surname, String address, String phone){
        setInputName(name);
        setInputSurname(surname);
        setInputAddress(address);
        setInputPhone(phone);
        clickInputMetroStation();
        driver.findElement(inputMetroStation).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        clickOnwardsButton();
    }
public void checkLoadingElements(){
     new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfElementsToBe(orderPage, 7));
}

}
