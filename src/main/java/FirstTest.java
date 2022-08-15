import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class FirstTest {

    @Test
    public void checkTopUpMobile(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        By countryCode = By.xpath("//button[@data-qa-node='phone-code']");
        By phoneNumb = By.xpath("//input[@data-qa-node='phone-number']");
        By amount = By.xpath(" //input[@data-qa-node='amount']");
        By cardFrom = By.xpath("//input[@data-qa-node='numberdebitSource']");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        By name = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        By surname = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        By submitBtn = By.xpath("//button[@data-qa-node ='submit']");


        driver.get("https://next.privat24.ua/mobile");
        driver.findElement(countryCode).sendKeys("+380");
        driver.findElement(phoneNumb).sendKeys("976444684");
        driver.findElement(amount).sendKeys(Keys.CONTROL + "A");
        driver.findElement(amount).sendKeys("555");
        driver.findElement(cardFrom).sendKeys("4004159115449003");
        driver.findElement(expDate).sendKeys("1129");
        driver.findElement(cvv).sendKeys("123");
        driver.findElement(name).sendKeys("Semen");
        driver.findElement(surname).sendKeys("Sakaly");
        driver.findElement(submitBtn).submit();


        By actualComment = By.xpath("//*[@data-qa-node='category']");
        By actualMobile = By.xpath("//*[@data-qa-node='details']");
        By actualCardFrom = By.xpath("//*[@data-qa-node='card']");
        By actualRecipient = By.xpath("//span[@data-qa-node='nameB']");
        By actualSum = By.xpath("//td//div[@data-qa-node='amount']");
        By actualCommission = By.xpath("//span[@data-qa-node='commission']");
        By actualCurrency = By.xpath("//span[@data-qa-node='commission-currency']");


        Assertions.assertEquals("Поповнення мобільного", driver.findElement(actualComment).getText());
        Assertions.assertEquals("Поповнення телефону. На номер +380976444684", driver.findElement(actualMobile).getText());
        Assertions.assertEquals("4004 **** **** 9003", driver.findElement(actualCardFrom).getText());
        Assertions.assertEquals("Kyivstar Ukraine", driver.findElement(actualRecipient).getText());
        Assertions.assertEquals("555 UAH", driver.findElement(actualSum).getText());
        Assertions.assertEquals("4", driver.findElement(actualCommission).getText());
        Assertions.assertEquals(" UAH", driver.findElement(actualCurrency).getText());

    }

}