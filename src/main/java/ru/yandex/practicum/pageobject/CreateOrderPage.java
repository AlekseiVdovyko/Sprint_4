package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateOrderPage {

    //поле driver
    WebDriver driver;
    //локатор поля имени
    private By firstNameUserField = By.xpath(".//input[@placeholder = '* Имя']");
    //локатор поля фамилии
    private By lastNameUserField = By.xpath(".//input[@placeholder = '* Фамилия']");
    //локатор поля адреса доставки
    private By addressDeliveryField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //локатор поля станции метро
    private By metroStationField = By.xpath(".//input[@placeholder = '* Станция метро']");
    //локатор поля номера телефона
    private By telephoneNumberField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private By fartherButton = By.xpath(".//button[text() = 'Далее']");
    //локатор поля "когда доставят"
    private By whenDeliverField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //локатор поля "срок аренды"
    private By rentalPeriodField = By.xpath(".//span[@class = 'Dropdown-arrow']");
    //локатор поля "комментарий"
    private By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //локатор кнопки "назад" на второй странице создания заказа
    private By backButton = By.xpath(".//button[text()='Назад']");
    //локатор кнопки "заказать" после заполнения второй формы
    private By orderOnSecondFormButton = By.xpath(".//button[2][text()='Заказать']");
    //локатор кнопки "нет" на форме подтверждения заказа
    private By orderCancelButton = By.xpath(".//button[text()='Нет']");
    //локатор кнопки "да" на форме подтверждения заказа
    private By acceptOrderButton = By.xpath(".//button[text()='Да']");
    //локатор подтверждения оформления заказа
    private By confirmOrderMessage = By.xpath(".//*[contains(text(), 'Номер заказа: ')]");


    public CreateOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/order");
    }

    public void setFirstNameUser(String firstNameUser) {
        driver.findElement(firstNameUserField).sendKeys(firstNameUser);
    }

    public void setLastNameUser(String lastNameUser) {
        driver.findElement(lastNameUserField).sendKeys(lastNameUser);
    }

    public void setAddressDelivery(String addressDelivery) {
        driver.findElement(addressDeliveryField).sendKeys(addressDelivery);
    }

    public void setMetroStation(String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation);
        By nameStation = By.xpath(".//*[text() = '" + metroStation + "']");
        driver.findElement(nameStation).click();

    }

    public void setTelephoneNumber(String telephoneNumber) {
        driver.findElement(telephoneNumberField).sendKeys(telephoneNumber);
    }

    public void clickFartherButton() {
        driver.findElement(fartherButton).click();
    }

    public void setWhenDeliver(String whenDeliver) {
        driver.findElement(whenDeliverField).sendKeys(whenDeliver);
        driver.findElement(By.xpath(".//*[@value = '" + whenDeliver + "']")).click();
    }

    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(".//div[text()='" + rentalPeriod + "']")).click();
    }

    public void setColorScooter(String colorScooter) {
        if(colorScooter.equals("чёрный жемчуг")) {
            driver.findElement(By.id("black")).click();
        } else {
            driver.findElement(By.id("grey")).click();
        }
    }

    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickBackButtonSecondPage() {
        driver.findElement(backButton).click();
    }

    public void clickOrderOnSecondFormButton() {
        driver.findElement(orderOnSecondFormButton).click();
    }

    public void clickCancelOrderButton() {
        driver.findElement(orderCancelButton).click();
    }

    public void clickAcceptOrderButton() {
        driver.findElement(acceptOrderButton).click();
    }

    public boolean isConfirmOrder() {
        return driver.findElement(confirmOrderMessage).isDisplayed();
    }

    //заполнения сеттеров значениями
    public void fillFirstForm(String firstNameUser, String lastNameUser, String addressDelivery,
                              String metroStation, String telephoneNumber) {
        setFirstNameUser(firstNameUser);
        setLastNameUser(lastNameUser);
        setAddressDelivery(addressDelivery);
        setMetroStation(metroStation);
        setTelephoneNumber(telephoneNumber);
    }

    public void fillSecondForm(String whenDeliver, String rentalPeriod,
                               String colorScooter, String comment) {
        setWhenDeliver(whenDeliver);
        setRentalPeriod(rentalPeriod);
        setColorScooter(colorScooter);
        setComment(comment);
    }
}
