import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анастасия О. on 15.02.2017.
 */
public class Tests {

    public TestManager manager;
    WebDriverWait wait;

    @Before
    public void start() {
        manager = new TestManager();
        manager.init();
        wait = new WebDriverWait(manager.browser(), 5);
    }

    @After
    public void tearDown() {
        manager.quit();
    }

    //Сохраняется текущие установленные город и телефон, затем изменяется город и сравниваются старый и новый город и телефон
    @Test
    public void verifyPhoneTest() {
        String currentCity = manager.browser().findElement(getCity()).getText();
        String currentPhone = manager.browser().findElement(getPhone()).getText();
        selectCity("Москва");
        String newCity = manager.browser().findElement(getCity()).getText();
        String newPhone = manager.browser().findElement(getPhone()).getText();
        Assert.assertNotEquals("Названия городов совпадают", currentCity, newCity);
        Assert.assertNotEquals("Названия телефонов совпадают",currentPhone, newPhone);
    }

    //Тест содержащий ошибки для отчета
    @Test
    public void verifyPhoneFailedTest() {
        String currentCity = manager.browser().findElement(getCity()).getText();
        String currentPhone = manager.browser().findElement(getPhone()).getText();
        selectCity("Москва");
        String newCity = manager.browser().findElement(getCity()).getText();
        String newPhone = manager.browser().findElement(getPhone()).getText();
        Assert.assertEquals("Названия городов совпадают", "Bad City", newCity);
        Assert.assertNotEquals("Названия телефонов совпадают",currentPhone, newPhone);
    }

    //Проверка ссылок: открывается каждая ссылка и сохраняется ее url, затем список url сравнивается с эталонным
    @Test
    public void verifySocialLinksTest() {
        List<String> linkList = getUrlFromPages();
        List<String> correctLinkList = new ArrayList<String>(linkList);
        Assert.assertEquals(linkList, correctLinkList);
    }

    public List<String> getUrlFromPages() {
        String currentWindow = manager.browser().getWindowHandle();
        List<WebElement> linkElementsList= manager.browser().findElements(By.xpath("//div[@class='dk-footer__social']/a"));
        List<String> linkList = new ArrayList<String>();
        for (WebElement link: linkElementsList) {
            link.click();
            String linkValue = link.getAttribute("href");
            String newWindow = new ArrayList<String>(manager.browser().getWindowHandles()).get(1);
            manager.browser().switchTo().window(newWindow);
            wait.until(ExpectedConditions.urlToBe(linkValue));
            linkList.add(manager.browser().getCurrentUrl());
            manager.browser().close();
            manager.browser().switchTo().window(currentWindow);
        }
        return linkList;
    }

    public void selectCity(String city) {
        manager.browser().findElement(getCity()).click();
        wait.until(ExpectedConditions.visibilityOf(manager.browser().findElement(By.xpath("//md-option[@value='"+city+"']"))));
        manager.browser().findElement(By.xpath("//md-option[@value='"+city+"']")).click();
    }

    public By getPhone() {
        return By.cssSelector("span[data-ng-bind='regionPhone.view']");
    }

    public By getCity() {
        return By.xpath("//md-select-value[@class='md-select-value']/span");
    }

}
