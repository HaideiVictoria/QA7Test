package pages;

import constans.Url_cart;
import constans.Url_jacket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartAnswearBasketPage extends BasePage {

    public CartAnswearBasketPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//button[@type='button']")
    private WebElement acceptCookies;
    @FindBy(xpath = "//*[@data-test='add_to_cart']")
    private WebElement basket;
    @FindBy(css =".CookiesInfo__cookiesInfoBtnWrapper__3q6Ss >button")
    private WebElement acceptCookiesJacketPage;

    @FindBy(css = ".ProductCard__sizeSelectWrapper__\\+ra4i .BaseSelectDropdown__selectEllipsis__Q6-ZS")
    private WebElement chooseSize;
    @FindBy(css= ".BaseSelectDropdown__selectActive__1dgp4 > div > ul > li:nth-child(2)")
    private WebElement jacketSize;
    @FindBy(xpath = "//*[@data-test='cart_icon']")
    private WebElement basketIcon;
    @FindBy(xpath = ".CookiesInfo__cookiesInfoBtnWrapper__3q6Ss >button")
    private WebElement acceptCookiesAuthorizationPage;

    @FindBy(xpath = "//*[@aria-label='Змінити кількість']")
    private WebElement plusButton;

    @FindBy(css =".CartItem__cartInfo__voRFT > span > div > span")
    private WebElement resultField;
    @FindBy(xpath = "//button[span='Видалити']")
    private WebElement deleteButton;
    @FindBy(css = ".FullCart__cartWrapper__g4oH8 .Summary__btnContainer__uosgJ > a > div")
    private WebElement buyButton;

    @FindBy(id ="username")
    private WebElement userName;

    @FindBy(id ="_password")
    private WebElement password;
    @FindBy(xpath ="//button[@type='submit']")
    private WebElement exit;


    static final Logger logger = LoggerFactory.getLogger(CartAnswearBasketPage.class);
    public CartAnswearBasketPage acceptCookies() {
        workWithElement.click(acceptCookies);
        return this;
    }

    public CartAnswearBasketPage acceptCookiesJacketPage() {
        try {
            workWithElement.click(acceptCookiesJacketPage);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this;
    }


    public CartAnswearBasketPage addToBasket() {
        basket.click();

logger.info("Try add product on basket");
        return this;
    }

    public CartAnswearBasketPage openJacketPage() {
        driver.get(Url_jacket.jacjetPage);
        return this;
    }

    public CartAnswearBasketPage size() {

     jacketSize.click();
        logger.info("Try choose a size");

        return this;
    }

    public CartAnswearBasketPage basketIconOpen() {
        basketIcon.click();

        logger.info("To see if there is a basket button for the product");
        return this;
    }
    public CartAnswearBasketPage clickOnPlusCountOfTimes(int count){
        for(int i = 0; i < count; i++){
            workWithElement.click(plusButton);
        }
        return this;
    }

public int returnResult(){
    return Integer.parseInt(workWithElement.getTextFromElement(resultField));
}
    public CartAnswearBasketPage isDeleteOnThePage(){
        if (deleteButton.isDisplayed()) {
            System.out.println("Кнопка 'Видалити 'на сторінці відображається.");
        } else {
            System.out.println("Помилка:Кнопка 'Видалити'на сторінці  не відображається.");
        }        logger.info("To see if there is a delete button on the page");

        return this;
    }
    public CartAnswearBasketPage isBasketIconOnThePage(){
        if (basketIcon.isDisplayed()) {
            System.out.println("Іконка 'Кошик'на сторінці відображається.");
        } else {
            System.out.println("Помилка:Іконка 'Кошик'на сторінці  не відображається.");
        }return this;
    }
    public CartAnswearBasketPage refresh()
    {
        driver.navigate().refresh();
        return this;
    }
public CartAnswearBasketPage buy(){
        buyButton.click();
        return this;
}
    public CartAnswearBasketPage isButtonBuyOnThePage(){
        if (buyButton.isDisplayed()) {
            System.out.println("Кнопка 'Купити'на сторінці відображається.");
        } else {
            System.out.println("Помилка: 'Купити' на сторінці  не відображається.");
        }              logger.info("To see if there is a buy button on the page");

        return this;
    }
    public CartAnswearBasketPage authorization(){
        userName.sendKeys("victoria_haidei@ukr.net");
        password.sendKeys("ryswyv-Fifcij-0behke");
        exit.click();

        return this;
    }
    public CartAnswearBasketPage acceptCookiesAuthorization() {
        try {
            workWithElement.click(acceptCookiesAuthorizationPage);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this;
    }
    public CartAnswearBasketPage openBuyPage() {
        driver.get(Url_cart.CART_PAGE);
        return this;
    }
    }



