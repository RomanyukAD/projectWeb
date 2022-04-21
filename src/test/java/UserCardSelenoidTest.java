import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.SpringApplication;
import org.testng.annotations.BeforeClass;
import pages.MainPage;
import qa.stub.StubServer;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.driver;


public class UserCardSelenoidTest {
    WebDriver driver;
    private String usertId;

    @BeforeClass
    public static void start() {
        System.out.println("=======Running junit 5 tests in parallel in LambdaTest Grid has started========");
    }

    @After
    public void teardown() {
        new MainPage().close();
    }

    @Before
    public void setup() {
        System.out.println("Test fixtures");
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "98.0");
        capabilities.setCapability("selenoid:options", selenoidOptions);
        try {
            driver = new RemoteWebDriver(
                    URI.create("http://127.0.0.1:4445/wd/hub").toURL(),
                    capabilities
            );
        } catch (Exception ignored) {
        }
    }


    @Test
    @Description("Проверка перехода по URL в карточку первого пользователя")
    public void getFirstUsersCard()  throws InterruptedException {
        usertId = "0";
        driver.get("http://localhost:3000/");
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'" + usertId + "')]"))
                .scrollIntoView(true).click();
        $("#root > div > div > div.MuiCardHeader-root.css-185gdzj-MuiCardHeader-root > div > span").shouldHave(text("Name"));
    }


}
