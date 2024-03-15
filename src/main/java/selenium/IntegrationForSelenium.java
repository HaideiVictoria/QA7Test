package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IntegrationForSelenium { public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.setBinary("C:\\chrome-win64\\chrome.exe");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    driver.get("https://www.google.com/");
    Thread.sleep(3000);


    driver.quit();
}
}
