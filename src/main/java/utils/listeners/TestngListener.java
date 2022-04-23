package utils.listeners;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pages.BasePage;

import static com.codeborne.selenide.Configuration.baseUrl;

public class TestngListener extends TestListenerAdapter {

  public void onTestFailure(ITestResult tr) {
    super.onTestFailure(tr);
    BasePage bt = (BasePage) tr.getInstance();
    WebDriver driver = bt.getDriver();
    takePhoto(driver);
    logCaseStep(tr);
    exceptedResult(tr);
  }


  @Attachment (value = "Неудачные снимки экрана:", type = "image / png")
  public byte[]  takePhoto(WebDriver driver){
    byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    return screenshotAs;
  }

  /**
   * Шаги теста печати
   * @param tr
   */
  @Attachment (value = "Действия следующие:")
  public String logCaseStep(ITestResult tr){
    String step = "1, откройте браузер";
    return step;
  }

  /**
   * Шаги теста печати
   * @param tr
   */
  @Attachment(value = "Ожидаемый результат:")
  public String exceptedResult(ITestResult tr){
    String result = "Показать результат запроса";
    return result;
  }
}

