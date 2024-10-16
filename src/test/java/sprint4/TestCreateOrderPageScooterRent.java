package sprint4;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.pageobject.CreateOrderPage;
import ru.yandex.practicum.pageobject.StartMainPage;


@RunWith(Parameterized.class)
public class TestCreateOrderPageScooterRent {
    private WebDriver driver = new ChromeDriver();
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

    public TestCreateOrderPageScooterRent(String firstNameUser, String lastNameUser,
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
        return new Object[][] {
                {"Петер", "Петров", "Москва", "Динамо", "80001234567", "02.12.2024", "сутки", "чёрный жемчуг", "комментарий"}
        };
    }

    @Test
    public void createNewOrderTopButtonWithAllPagesAndConfirmOrderButtonNotWork() {
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
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

    @Test
    public void createNewOrderDownButtonWithAllPagesAndConfirmOrderButtonNotWork() {
        //driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
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

    @Test
    public void createNewOrderAndPushBackButtonOnSecondForm() {
        startMainPage.open();
        startMainPage.clickCookieButton();
        startMainPage.clickOrderTopButton();
        createOrder.fillFirstForm(firstNameUser, lastNameUser, addressDelivery, metroStation, telephoneNumber);
        createOrder.clickFartherButton();
        createOrder.clickBackButtonSecondPage();
    }

    @Test
    public void createNewOrderAndCancelConfirmOrder() {
        startMainPage.open();
        startMainPage.clickCookieButton();
        startMainPage.clickOrderTopButton();
        createOrder.fillFirstForm(firstNameUser, lastNameUser, addressDelivery, metroStation, telephoneNumber);
        createOrder.clickFartherButton();
        createOrder.fillSecondForm(whenDeliver, rentalPeriod, colorScooter, comment);
        createOrder.clickOrderOnSecondFormButton();
        createOrder.clickCancelOrderButton();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
