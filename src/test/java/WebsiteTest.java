import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.Augmenter;

/**
 * Created by Анастасия Цыбулько on 12.02.2017.
 */
public class WebsiteTest {
    @Test
    public void webTest() throws Exception {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Анастасия Цыбулько\\Downloads\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.yandex.ru/");
        driver.findElement(By.id("text")).sendKeys("Selenium Webdriver");
        driver.findElement(By.cssSelector(".suggest2-form__button")).click();
        Thread.sleep(2000);
        driver.get(driver.getCurrentUrl());
        driver.findElement(By.className("needsclick")).click();

        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshot.png"));




    }
}
