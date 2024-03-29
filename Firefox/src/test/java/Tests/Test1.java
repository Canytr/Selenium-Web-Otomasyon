package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Test1 {

    public  WebDriver driver;

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\can-123\\Desktop\\Firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
        String url = "https://www.gittigidiyor.com/";  /* www.gittigidiyor.com sitesi açılır */
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TestHome(){

        /* Ana sayfanın açıldığı kontrol edilir. Siteye login olunur */

        WebElement signbtn= driver.findElement(By.className("gekhq4-6 hnYHyk"));
        signbtn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement mailbox= driver.findElement(By.id("L-UserNameField"));
        mailbox.click();
        mailbox.sendKeys("Your Mail Adress");

        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        password.sendKeys("Your Password");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.id("gg-login-enter")).click();
    }
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}
