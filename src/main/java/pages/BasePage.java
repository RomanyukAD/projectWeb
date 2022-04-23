package pages;

import annotations.UrlPath;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Listeners;
import utils.listeners.TestngListener;


@Listeners({TestngListener.class})
public abstract class BasePage<T> {
    private static String baseUrl = "http://localhost:3000";
    public WebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    private String getUrlPath() {
        UrlPath urlPath = getClass().getAnnotation(UrlPath.class);
        if (urlPath != null) {
            return urlPath.value();
        }

        return "";
    }

    @Step
    public T open() {
        Selenide.open(baseUrl);

        return (T) this;
    }


    @Step
    public T close() {
        Selenide.closeWebDriver();

        return (T) this;
    }


}
