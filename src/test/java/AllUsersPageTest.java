import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.springframework.boot.SpringApplication;
import org.testng.annotations.BeforeClass;
import pages.MainPage;
import qa.stub.StubServer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AllUsersPageTest {

    @BeforeClass
    public static void startStubServer(String[] args) {
        SpringApplication.run(StubServer.class, args);
    }

    @Test
    @Description("Получить цвет линка  в hex до перехода в карточку пользователя")
    public void getParamsFirstUserInTheList(){
        new MainPage().open();
        $(By.xpath(".MuiPaper-root .MuiTypography-root"));
        webdriver().shouldHave(url("http://localhost:3000/"));
        $("#root > div > div:nth-child(1) > a > div > div > span").shouldHave(text("Name"));
        $("#root > div > div:nth-child(1) > div > p:nth-child(1)").shouldHave(text("Id"));
        $("#root > div > div:nth-child(1) > div > p:nth-child(2)").shouldHave(text("Grade"));
    }


    @Test
    @Description("Получить цвет линка  в hex до перехода в карточку пользователя")
    public void getGetColorLinkBeforeUserCard(){
        new MainPage().open();
        $(By.xpath(".MuiPaper-root .MuiTypography-root"));
        webdriver().shouldHave(url("http://localhost:3000/"));
        $("#root > div > div > div.MuiCardHeader-root.css-185gdzj-MuiCardHeader-root > div > span").shouldHave(text("Name"));
        String titleColor = $(By.xpath("//*[@id=\"root\"]/div/div[1]/a/div/div/span")).getCssValue("color");
        String hex = Color.fromString(titleColor).asHex();
        System.out.println(hex);
    }

    @Test
    @Description("Получить цвет линка  в hex после  перехода в карточку пользователя и возвращения на страницу со списком пользователей")
    public void getGetColorLinkAfterUserCard(){
        String usertId = "0";
        new MainPage().open();
        webdriver().shouldHave(url("http://localhost:3000/"));
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'" + usertId + "')]"))
                .scrollIntoView(true).click();
        webdriver().shouldHave(url("http://localhost:3000/" + usertId));
        new MainPage().open();
        $(By.xpath(".MuiPaper-root .MuiTypography-root"));
        webdriver().shouldHave(url("http://localhost:3000/"));
        String titleColor = $(By.xpath("//*[@id=\"root\"]/div/div[1]/a/div/div/span")).getCssValue("color");
        String hex = Color.fromString(titleColor).asHex();
        System.out.println(hex);
    }

}
