package home_work4;

import driver_factory.DriverSetUp;
import lesson7.custom_waiter_class.CustomWaiterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Task4SearchWord {

    //*[@id="user-location-popup"]/div/div[1] для закриття фрейму з містами
    @Test(dataProvider ="searchWords" )
    public void testFoxtrotSearch(String машина, String input, String смысл) {
        WebDriver driver = DriverSetUp.setUpDriver();
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

        driver.quit();
    }@DataProvider(name = "searchWords")
    public Object[][] searchWords() {
        return new Object[][] {
                {"машина", "input", "смысл"}
        };
    }
}

