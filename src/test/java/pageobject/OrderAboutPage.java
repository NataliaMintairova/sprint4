package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderAboutPage {
    private WebDriver driver;

    //поле Когда привезти самокат
    private By whenBring = By.xpath(".//input[contains(@placeholder, '* Когда привезти')]");
    //выбранная дата в календаре
    private By selectedDste = By.xpath(".//div[contains(@class, 'day--selected')]");
    //поле Срок аренды
    private By rentalTime = By.className("Dropdown-placeholder");
    //значение Двое суток в выпадающем списке
    private By numberOf2Days = By.xpath(".//div[text()='двое суток']");
    //значение Трое суток в выпадающем списке
    private By numberOf3Days = By.xpath(".//div[text()='трое суток']");
    //чекбокс Черного цвета самоката
    private By blackPearl = By.xpath(".//input[@id='black' and @type='checkbox']");
    //чекбокс Серого цвета самоката
    private By greyHopeless = By.xpath(".//input[@id='grey' and @type='checkbox']");
    //поле Комментарий для курьера
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка Заказать
    private By orderButton = By.xpath(".//button[contains(@class, 'Button_Middle') and text()='Заказать']");
    //кнопка Да в окне Хотите оформить заказ
    private By yesApplyButton = By.xpath(".//button[contains(@class, 'Button_Middle') and text()='Да']");
    //текст Заказ оформлен в окне оформленного заказа
    private By windowOrderApplied = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderAboutPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectDeliveryDate(String date){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(whenBring));
        driver.findElement(whenBring).sendKeys(date);
    }
    public void clickWhenBringButton(){
        driver.findElement(whenBring).click();
    }
    public void clickSelectedDateButton(){
        driver.findElement(selectedDste).click();
    }
    public void clickRentalTimeButton(){
        driver.findElement(rentalTime).click();
    }
    public void choose2RentalTime(){
        driver.findElement(numberOf2Days).click();
    }
    public void choose3RentalTime(){
        driver.findElement(numberOf3Days).click();
    }
    public void chooseBlackCheckbox(){
        driver.findElement(blackPearl).click();
    }
    public void chooseGreyCheckbox(){
        driver.findElement(greyHopeless).click();
    }
    public void setComment(){
        driver.findElement(comment).sendKeys("Мой комментарий");
    }
    public void clickOrderButton(){
        driver.findElement(orderButton).isEnabled();
        driver.findElement(orderButton).click();
    }
    public void clickYesApplyOrderButton(){
        driver.findElement(yesApplyButton).isEnabled();
        driver.findElement(yesApplyButton).click();
    }
    public boolean isDisplayedWindowOrderApplied(){
        return driver.findElement(windowOrderApplied).isDisplayed();
    }
}
