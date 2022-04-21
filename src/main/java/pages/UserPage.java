package pages;

import annotations.UrlPath;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;


@UrlPath("/{id}")
public class UserPage extends BasePage {

    @Step
    public String getUrlPage() {
        String currentURL = WebDriverRunner.getWebDriver().getCurrentUrl();
        return currentURL;
    }
}
