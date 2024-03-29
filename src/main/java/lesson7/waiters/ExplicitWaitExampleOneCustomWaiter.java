package lesson7.waiters;

import driver_factory.DriverSetUp;
import lesson7.custom_waiter_class.CustomWaiterClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExplicitWaitExampleOneCustomWaiter {public static void main(String[] args) throws InterruptedException {
    WebDriver driver = DriverSetUp.setUpDriver();
    driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
    CustomWaiterClass waiter = new CustomWaiterClass(driver);
    //visibilityOfElementLocated
    waiter.waitForVisibilityOfElementLocated(By.id("accept-choices")).click();

    //frameToBeAvailableAndSwitchToIt
    waiter.waitForFrameAndSwitch(By.id("iframeResult"));
    driver.findElement(By.xpath("//button[@onclick=\"myFunction()\"]")).click();

    //alertIsPresent
    Alert alert = waiter.waitForAlertAndSwitch();
    System.out.println(alert.getText());
    alert.accept();
    Thread.sleep(3000);
    driver.quit();


}
}
