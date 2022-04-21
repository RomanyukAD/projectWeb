package pages;

import annotations.UrlPath;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;


public abstract  class BasePage<T> {
    private static String baseUrl = "http://localhost:3000";

    private String getUrlPath() {
        UrlPath urlPath = getClass().getAnnotation(UrlPath.class);
        if(urlPath != null) {
            return urlPath.value();
        }

        return "";
    }

    @Step
    public T open() {
        Selenide.open(baseUrl);

        return (T)this;
    }


    @Step
    public T close() {
        Selenide.closeWebDriver();

        return (T)this;
    }




}
