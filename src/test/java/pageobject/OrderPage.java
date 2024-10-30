package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private WebDriver driver;

    //поле для ввода имени
    private By inputName = By.xpath(".//input[@placeholder='* Имя']");
    //поле для ввода фамилии
    private By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //поле для ввода адреса
    private By inputAddress = By.xpath(".//input[contains(@placeholder, '* Адрес')]");
    //поле для выбора станции метро
    private By inputMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //поле для ввода телефона
    private By inputPhone = By.xpath(".//input[contains(@placeholder, '* Телефон')]");
    //кнопка Далее
    private By onwardsButton = By.xpath(".//button[contains(@class, 'Button_Middle')]");
    //форма заказа первое окно
    private By orderPage = By.xpath(".//div[contains(@class, 'App_App')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setInputSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }

    public void setInputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void clickInputMetroStation() {
        driver.findElement(inputMetroStation).click();
    }

    public void setInputPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void clickOnwardsButton() {
        driver.findElement(onwardsButton).isEnabled();
        driver.findElement(onwardsButton).click();
    }

    public void orderFirstWindow(String name, String surname, String address, String phone) {
        setInputName(name);
        setInputSurname(surname);
        setInputAddress(address);
        setInputPhone(phone);
        clickInputMetroStation();
        driver.findElement(inputMetroStation).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        clickOnwardsButton();
    }

    public boolean checkLoadingOrderPage() {
      return driver.findElement(orderPage).isDisplayed();
    }

}
