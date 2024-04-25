import driver.DriverSetUp;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.AuthorizationPage;
import pages.BasePage;
import pages.CartAnswearBasketPage;
import pages.MainProductsPage;
import utils.MyAllureListener;

@Listeners({MyAllureListener.class})
public class BaseTest {  protected WebDriver driver = DriverSetUp.startDriver();
    protected WaitersClass waiters= new WaitersClass(driver);
    protected WorkWithElementClass workWithElement = new WorkWithElementClass(driver);
    protected BasePage basePage = new BasePage(driver);
    protected AuthorizationPage clickerPage = new AuthorizationPage(driver);
    protected MainProductsPage mainProductsPage= new MainProductsPage(driver);
   protected CartAnswearBasketPage cartAnswearBasketPage=new CartAnswearBasketPage(driver);
@BeforeSuite
public void driverInit(){
    driver = DriverSetUp.startDriver();
}
@AfterSuite
public void stopDriver(){
    driver.quit();
}


}
