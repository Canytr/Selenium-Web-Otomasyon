package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Test2 {

    public WebDriver driver;

    @Before
    public void setupDriver(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\can-123\\Desktop\\Chrome\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }
    @Test
    public void TestSearch(){

        /* Arama kutucuğuna bilgisayar kelimesi girilir  */
        WebElement searchBox = driver.findElement(By.className("sc-4995aq-0 sc-14oyvky-0 itMXHg"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.className("qjixn8-0 sc-1bydi5r-0 hKfdXF")).click();

        /* Arama sonuçları sayfasından 2.sayfa açılır ve Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir */
        driver.findElement(By.xpath(".//*[@class='desktop']/a[2]")).click();
        driver.findElement(By.xpath(".//*[@id='item-info-block-532779150']/div[1]/a[1]")).click();

        WebElement price= driver.findElement(By.xpath(".//*[@class='fiyat robotobold price-txt']/ins[1]"));
        String priceText= price.getText();

        /* Seçilen ürün sepete eklenir */
        WebElement quantityBox = driver.findElement(By.className("control-button gg-ui-button plr10 gg-ui-btn-default"));
        quantityBox.click();
        quantityBox.clear();
        quantityBox.sendKeys("1");

        WebElement basketBtn = driver.findElement(By.className("gg-ui-btn-default padding-none"));
        basketBtn.click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("header-cart-empty gg-d-24 hidden")).click();

        /* Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır */
        WebElement priceBasket= driver.findElement(By.className("sp-price-lowPrice"));
        String priceText2= priceBasket.getText();
        if(priceText.compareTo(priceText2)>0){

            /* Sepetteki ürün adetinin artırılması */
            WebElement quantityBasket = driver.findElement(By.id("CountInput"));
            quantityBasket.click();
            quantityBasket.clear();
            quantityBasket.sendKeys("1");
            driver.findElement(By.className("IncNumber gg-icon gg-icon-plus")).click();
        }
        /* Sepetteki ürünlerin boşaltılması */
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.className("DecNumber gg-icon gg-icon-minus")).click();
    }
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}
