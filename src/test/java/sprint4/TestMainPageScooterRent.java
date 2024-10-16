package sprint4;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.pageobject.StartMainPage;
import java.util.concurrent.TimeUnit;


public class TestMainPageScooterRent {

    private WebDriver driver = new ChromeDriver();
    StartMainPage startMainPage = new StartMainPage(driver);

    @Test
    public void checkButtonsOrderTopCookieStatusOrder() {
        startMainPage.open();
        startMainPage.clickCookieButton();
        startMainPage.clickOrderTopButton();
        startMainPage.clickOrderStatusButton();
    }

    @Test
    public void checkTopOrderButtonAndCookie() {
        startMainPage.open();
        startMainPage.clickCookieButton();
        startMainPage.clickOrderTopButton();
    }

    @Test
    public void checkDownOrderButtonAndCookie() {
        startMainPage.open();
        startMainPage.clickCookieButton();
        startMainPage.clickOrderDownButton();
    }

    @Test
    public void checkOrderStatusButton() {
        startMainPage.open();
        startMainPage.clickCookieButton();
        startMainPage.clickOrderStatusButton();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        startMainPage.setNumberOrderField("895290");
        startMainPage.clickGoButtonCheckOrder();
    }

    @Test
    public void checkQuestionSelector() {
        startMainPage.open();
        startMainPage.clickCookieButton();
        startMainPage.clickFirstQuestionSelector();
        startMainPage.clickSecondQuestionSelector();
        startMainPage.clickThirdQuestionSelector();
        startMainPage.clickForthQuestionSelector();
        startMainPage.clickFirthQuestionSelector();
        startMainPage.clickSixthQuestionSelector();
        startMainPage.clickSeventhQuestionSelector();
        startMainPage.clickEighthQuestionSelector();
    }


    @After
    public void teardown() {
        driver.quit();
    }

}
