package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartMainPage {
    //поле driver
    private WebDriver driver;
    //локатор кнопки купи
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    //локатор кнопки "Заказать" сверху
    private By orderTopButton = By.className("Button_Button__ra12g");
    //локатор кнопки "Заказать" снизу
    private By orderDownButton = By.xpath(".//div[5]/button[text()='Заказать']");
    //локатор кнопки "статуса заказа"
    private By orderStatusButton = By.className("Header_Link__1TAG7");
    //поле ввода номера заказа
    private By orderNumberField = By.xpath(".//input[@placeholder = 'Введите номер заказа']");
    //кнопка GO проверки статуса заказа
    private By goButton = By.xpath(".//button[text()='Go!']");
    //логотип "Самоката"
    private By logoScooter = By.xpath(".//img[@alt = 'Scooter']");
    //логотип "Яндекса"
    private By logoYandex = By.xpath(".//img[@alt = 'Yandex']");


    //локаторы раскрывающегося списка вопросов
    private By firstQuestionSelector = By.xpath(".//div[text() = 'Сколько это стоит? И как оплатить?']");
    private By secondQuestionSelector = By.xpath(".//div[text() = 'Хочу сразу несколько самокатов! Так можно?']");
    private By thirdQuestionSelector = By.xpath(".//div[text() = 'Как рассчитывается время аренды?']");
    private By forthQuestionSelector = By.xpath(".//div[text() = 'Можно ли заказать самокат прямо на сегодня?']");
    private By firthQuestionSelector = By.xpath(".//div[text() = 'Можно ли продлить заказ или вернуть самокат раньше?']");
    private By sixthQuestionSelector = By.xpath(".//div[text() = 'Вы привозите зарядку вместе с самокатом?']");
    private By seventhQuestionSelector = By.xpath(".//div[text() = 'Можно ли отменить заказ?']");
    private By eighthQuestionSelector = By.xpath(".//div[text() = 'Я жизу за МКАДом, привезёте?']");


    public StartMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }

    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }

    public void clickOrderDownButton() {
        driver.findElement(orderDownButton).click();
    }

    public void setNumberOrderField(String orderNumber) {
        driver.findElement(orderNumberField).sendKeys(orderNumber);
    }

    public void clickGoButtonCheckOrder() {
        driver.findElement(goButton).click();
    }

    public void clickFirstQuestionSelector() {
        driver.findElement(firstQuestionSelector).click();
    }

    public void clickSecondQuestionSelector() {
        driver.findElement(secondQuestionSelector).click();
    }

    public void clickThirdQuestionSelector() {
        driver.findElement(thirdQuestionSelector).click();
    }

    public void clickForthQuestionSelector() {
        driver.findElement(forthQuestionSelector).click();
    }

    public void clickFirthQuestionSelector() {
        driver.findElement(firthQuestionSelector).click();
    }

    public void clickSixthQuestionSelector() {
        driver.findElement(sixthQuestionSelector).click();
    }

    public void clickSeventhQuestionSelector() {
        driver.findElement(seventhQuestionSelector).click();
    }

    public void clickEighthQuestionSelector() {
        driver.findElement(eighthQuestionSelector).click();
    }

}
