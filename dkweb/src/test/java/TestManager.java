import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Анастасия О. on 15.02.2017.
 */
public class TestManager {
    private WebDriver driver;

    public void init() {
        System.out.println("Пытаемся открыть браузер");
        System.setProperty("webdriver.gecko.driver","src\\test\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://dreamkas.ru");
    }

    public void quit() {
        driver.quit();
        System.out.println("Браузер закрыт");
    }

    public WebDriver browser() {
        return driver;
    }
}
