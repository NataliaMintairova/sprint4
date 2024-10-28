package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage {

    private WebDriver driver;

    private final static String FAQ_QUESTION_PATTERN = ".//div[text()='%s']";

public static final String QUESTION_HOW_MUCH_COSTS ="Сколько это стоит? И как оплатить?";
public static final String QUESTION_WANT_SOME_SCOOTERS = "Хочу сразу несколько самокатов! Так можно?";
public static final String QUESTION_CALC_RENT_TIME = "Как рассчитывается время аренды?";
public static final String QUESTION_ORDER_TODAY = "Можно ли заказать самокат прямо на сегодня?";
public static final String QUESTION_EXTEND_RETURN_EARLIER = "Можно ли продлить заказ или вернуть самокат раньше?";
public static final String QUESTION_CHARGING_TOGETHER = "Вы привозите зарядку вместе с самокатом?";
public static final String QUESTION_CANCEL_ORDER = "Можно ли отменить заказ?";
public static final String QUESTION_DELIVER_OUTSIDE_MRR = "Я жизу за МКАДом, привезёте?";

    private final static String FAQ_ANSWER_PATTERN = ".//p[text()='%s']";

public static final String ANSWER_HOW_MUCH_COSTS = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
public static final String ANSWER_WANT_SOME_SCOOTERS = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
public static final String ANSWER_CALC_RENT_TIME = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
public static final String ANSWER_ORDER_TODAY = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
public static final String ANSWER_EXTEND_RETURN_EARLIER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
public static final String ANSWER_CHARGING_TOGETHER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
public static final String ANSWER_CANCEL_ORDER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
public static final String ANSWER_DELIVER_OUTSIDE_MRR= "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

private By upperOrderButton = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[contains(@class, 'Button_Button')]");
private By lowerOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle')]");

public MainPage(WebDriver driver){
    this.driver = driver;
}

public void clickFAQQuestionButton(String questionMessage){
    String questionLocator = String.format(FAQ_QUESTION_PATTERN, questionMessage);
    driver.findElement(By.xpath(questionLocator)).click();
}

    public void scrollToElement(String questionMessage){
        String questionLocator = String.format(FAQ_QUESTION_PATTERN, questionMessage);
        WebElement element = driver.findElement(By.xpath(questionLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public boolean checkVisibleAnswer(String answerMessage){
        String answerLocator = String.format(FAQ_ANSWER_PATTERN, answerMessage);
    return driver.findElement(By.xpath(answerLocator)).isDisplayed();
    }

    public void isEnabledQuestionButton(String questionMessage){
    String questionLocator = String.format(FAQ_QUESTION_PATTERN, questionMessage);
    driver.findElement(By.xpath(questionLocator)).isEnabled();
    }

    public void clickUpperOrderButton(){
    driver.findElement(upperOrderButton).isEnabled();
    driver.findElement(upperOrderButton).click();
    }

    public void scrollToLowerOrderButton(){
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickLowerOrderButton(){
    driver.findElement(lowerOrderButton).isEnabled();
    driver.findElement(lowerOrderButton).click();
    }
}
