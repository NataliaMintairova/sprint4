package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    //адрес главной страницы
    public static final String URL_MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";
    //паттерн для локаторов вопросов
    private final static String faqQuestionPattern = ".//div[text()='%s']";
//констатнты для паттерна локатора вопросов
public static final String QUESTION_HOW_MUCH_COSTS ="Сколько это стоит? И как оплатить?";
public static final String QUESTION_WANT_SOME_SCOOTERS = "Хочу сразу несколько самокатов! Так можно?";
public static final String QUESTION_CALC_RENT_TIME = "Как рассчитывается время аренды?";
public static final String QUESTION_ORDER_TODAY = "Можно ли заказать самокат прямо на сегодня?";
public static final String QUESTION_EXTEND_RETURN_EARLIER = "Можно ли продлить заказ или вернуть самокат раньше?";
public static final String QUESTION_CHARGING_TOGETHER = "Вы привозите зарядку вместе с самокатом?";
public static final String QUESTION_CANCEL_ORDER = "Можно ли отменить заказ?";
public static final String QUESTION_DELIVER_OUTSIDE_MRR = "Я жизу за МКАДом, привезёте?";

//константы ответов в FAQ
public static final String ANSWER_HOW_MUCH_COSTS = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
public static final String ANSWER_WANT_SOME_SCOOTERS = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
public static final String ANSWER_CALC_RENT_TIME = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
public static final String ANSWER_ORDER_TODAY = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
public static final String ANSWER_EXTEND_RETURN_EARLIER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
public static final String ANSWER_CHARGING_TOGETHER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
public static final String ANSWER_CANCEL_ORDER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
public static final String ANSWER_DELIVER_OUTSIDE_MRR= "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

//раскрытый ответ
private By OpenedAnswer = By.xpath(".//div[contains(@class, 'accordion__panel') and not(@hidden)]/p");
//кнопка Заказать вверху странцы
private By upperOrderButton = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[contains(@class, 'Button_Button')]");
//кнопка Заказать под цепочкой действий
private By lowerOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button[contains(@class, 'Button_Button')]");

public MainPage(WebDriver driver){
    this.driver = driver;
}

public void clickFAQQuestionButton(String questionMessage){
    String questionLocator = String.format(faqQuestionPattern, questionMessage);
    driver.findElement(By.xpath(questionLocator)).click();
}

    public void scrollToElement(String questionMessage){
        String questionLocator = String.format(faqQuestionPattern, questionMessage);
        WebElement element = driver.findElement(By.xpath(questionLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getAnswersText(){ //String answerMessage){
    return driver.findElement(OpenedAnswer).getText();
    }

    public void isEnabledQuestionButton(String questionMessage){
    String questionLocator = String.format(faqQuestionPattern, questionMessage);
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

    public void isAnswerVisible(){
    new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(OpenedAnswer));
    }
}
