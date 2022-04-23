import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.springframework.boot.SpringApplication;
import org.testng.annotations.BeforeClass;
import pages.MainPage;
import qa.stub.StubServer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;


public class UserCardTest {
    private String usertId;

    @BeforeClass
    public static void startStubServer(String[] args) {
        SpringApplication.run(StubServer.class, args);
    }

    @Test
    @Description("Проверка перехода по URL в карточку первого пользователя")
    public void getFirstUsersCard() {
        usertId = "0";

        new MainPage().open();
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'" + usertId + "')]"))
                .scrollIntoView(true).click();
        webdriver().shouldHave(url("http://localhost:3000/" + usertId));
    }

    @Test
    @Description("Проверка наличия поля Name в карточке первого пользователя")
    public void getNameInUsersCard() {
        usertId = "0";

        new MainPage().open();
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'" + usertId + "')]"))
                .scrollIntoView(true).click();
        $("#root > div > div > div.MuiCardHeader-root.css-185gdzj-MuiCardHeader-root > div > span").shouldHave(text("Name"));
    }

    @Test
    @Description("Проверка наличия поля Id в карточке первого пользователя")
    public void getIdInUsersCard() {
        usertId = "0";

        new MainPage().open();
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'" + usertId + "')]"))
                .scrollIntoView(true).click();
        $("#root > div > div > div.MuiCardContent-root.css-46bh2p-MuiCardContent-root > p:nth-child(0)").shouldHave(text("Id"));
    }


    @Test
    @Description("Проверка наличия поля School Name в карточке первого пользователя")
    public void getSchoolNameInUsersCard() {
        usertId = "0";

        new MainPage().open();
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'" + usertId + "')]"))
                .scrollIntoView(true).click();
        $("#root > div > div > div.MuiCardContent-root.css-46bh2p-MuiCardContent-root > p:nth-child(1)").shouldHave(text("School Name"));
    }

    @Test
    @Description("Проверка наличия поля Grade в карточке первого пользователя")
    public void getGradeInUsersCard() {
        usertId = "0";

        new MainPage().open();
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'" + usertId + "')]"))
                .scrollIntoView(true).click();
        $("#root > div > div > div.MuiCardContent-root.css-46bh2p-MuiCardContent-root > p:nth-child(2)").shouldHave(text("Grade"));
    }

    @Test
    @Description("Проверка наличия поля City в карточке первого пользователя")
    public void getCityInUsersCard() {
        usertId = "0";

        new MainPage().open();
        $(By.xpath("//div[contains(@class, 'MuiPaper-root')]/a[contains(@href,'" + usertId + "')]"))
                .scrollIntoView(true).click();
        $("#root > div > div > div.MuiCardContent-root.css-46bh2p-MuiCardContent-root > p:nth-child(3)").shouldHave(text("City"));
    }

}
