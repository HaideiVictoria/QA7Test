package home_work4;

import driver_factory.DriverSetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import lesson7.custom_waiter_class.CustomWaiterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class testngParametersHome {
    static WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    public void preconditions(String browser){
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
        }
    }
    @AfterClass
    public void postConditions(){
        driver.quit();
    }


    @Test(dataProvider ="searchWords" )
public void testFoxtrotSearch(String машина, String input, String смысл) {

    driver.get("https://www.foxtrot.com.ua/");
    try{
        driver.findElement(By.xpath("//*[@id=\'user-location-popup\']/div/div[1]")).click();
    } catch (
            NoSuchElementException e){
        System.out.println("element not found!!!");
    }
    new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.xpath("//*[@id=\"js-fix-header\"]//input[1]"))
            .sendKeys("машина");
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"js-fix-header\"]//input[1]")).isDisplayed());
    driver.findElement(By.xpath("//*[@id=\"js-fix-header\"]//input[2]")).click();
    new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.xpath("//*[@id=\"js-fix-header\"]//input[1]"))
            .sendKeys("input");
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"js-fix-header\"]//input[1]")).isDisplayed());
    driver.findElement(By.xpath("//*[@id=\"js-fix-header\"]//input[2]")).click();
    new CustomWaiterClass(driver).waitForVisibilityOfElementLocated(By.xpath("//*[@id=\"js-fix-header\"]//input[1]"))
            .sendKeys("смысл");
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"js-fix-header\"]//input[1]")).isDisplayed());
    driver.findElement(By.xpath("//*[@id=\"js-fix-header\"]//input[2]")).click();


}@DataProvider(name = "searchWords")
public Object[][] searchWords() {
    return new Object[][] {
            {"машина", "input", "смысл"}
    };
}
}

