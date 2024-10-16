package sprint4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import ru.yandex.practicum.pageobject.CreateOrderPage;
import ru.yandex.practicum.pageobject.StartMainPage;

@RunWith(Parameterized.class)
public class TestCreateOrderAndConfirmOrderEdgeBrowser {

    private WebDriver driver = new EdgeDriver();
    StartMainPage startMainPage = new StartMainPage(driver);
    CreateOrderPage createOrder = new CreateOrderPage(driver);

    private final String firstNameUser;
    private final String lastNameUser;
    private final String addressDelivery;
    private final String metroStation;
    private final String telephoneNumber;
    private final String whenDeliver;
    private final String rentalPeriod;
    private final String colorScooter;
    private final String comment;

    public TestCreateOrderAndConfirmOrderEdgeBrowser(String firstNameUser, String lastNameUser,
                                                     String addressDelivery,
                                                     String metroStation, String telephoneNumber,
                                                     String whenDeliver, String rentalPeriod,
                                                     String colorScooter, String comment) {
        this.firstNameUser = firstNameUser;
        this.lastNameUser = lastNameUser;
        this.addressDelivery = addressDelivery;
        this.metroStation = metroStation;
        this.telephoneNumber = telephoneNumber;
        this.whenDeliver = whenDeliver;
        this.rentalPeriod = rentalPeriod;
        this.colorScooter = colorScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] usersOrderData() {
        //тестовые данные
        return new Object[][] {
                {"Петер", "Петров", "Москва", "Сокольники", "80001234567", "02.12.2024", "сутки", "чёрный жемчуг", "комментарий"},
                {"Иван", "Иванов", "Москва", "Сокольники", "69996667755", "25.11.2024", "двое суток", "серая безысходность", "хочу кататься"},
                {"Сергей", "Кузнецов", "Москва", "Лубянка", "66666666666", "25.01.2025", "трое суток", "чёрный жемчуг", "заранее позвоните"},
                {"Максим", "Горький", "Москва", "Динамо", "12345678900", "25.12.2025", "четверо суток", "серая безысходность", "не забудьте его зарядить"}
        };
    }

    @Test
    public void createNewOrderWithAllPagesAndConfirmOrder() {
        startMainPage.open();
        startMainPage.clickCookieButton();
        startMainPage.clickOrderTopButton();
        createOrder.fillFirstForm(firstNameUser, lastNameUser, addressDelivery, metroStation, telephoneNumber);
        createOrder.clickFartherButton();
        createOrder.fillSecondForm(whenDeliver, rentalPeriod, colorScooter, comment);
        createOrder.clickOrderOnSecondFormButton();
        createOrder.clickAcceptOrderButton();
        Assert.assertTrue("Заказ не подтвержден", createOrder.isConfirmOrder());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
