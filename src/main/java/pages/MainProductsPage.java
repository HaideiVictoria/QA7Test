package pages;

import constans.UrlMainPage;
import constans.Url_jacket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProductsPage extends BasePage {


    public MainProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"productsSearch\"]")
    private WebElement productsSearch;
    @FindBy(xpath = "//*[@id=\"root\"]//h2[1]")
    private WebElement searchResultWomensShoes;
    @FindBy(xpath = "/html/body/div[2]//button")
    private WebElement acceptCookies;
    @FindBy(css= ".BaseSelectDropdown__selectActive__1dgp4")
    private WebElement jacket;
@FindBy(xpath = "//*[@data-test='add_to_cart']")
private WebElement basket;

   @FindBy(xpath= "//*[@data-test='size_dropdown'][1]")
    private WebElement jacketSize;
    @FindBy(css= "BaseSelectDropdown__selectContainerHasAFilter__iH6AL")
    private WebElement sizeS;
    @FindBy(xpath = "//div[@class='ProductCard__priceSale__qUu34']")
    private WebElement price;

    static final Logger logger = LoggerFactory.getLogger(MainProductsPage.class);
    public MainProductsPage openMainProductsPage() {
        driver.get(UrlMainPage.MAIN_PRODUCTS_PAGE);
        logger.info("Open main page");
        return this;
    }

    public MainProductsPage acceptCookies() {
        try {
            workWithElement.click(acceptCookies);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return this;
    }

    public MainProductsPage productSearchOmThePage() {
        productsSearch.sendKeys("Куртка Tommy Jeans жіноча колір чорний зимова");
        productsSearch.click();
        if (searchResultWomensShoes.isDisplayed()) {
            System.out.println("Результати пошуку для :Куртка Tommy Jeans.Кількість вибраних товарів: 126");
        } else {
            System.out.println("Нажаль, ми не знайшли того, що Ви шукаєте. Скористайтеся меню.");
        }
        return this;
    }
    public MainProductsPage openJacketPage() {
        driver.get(Url_jacket.jacjetPage);
        return this;
    }
    public MainProductsPage isPriceOnThePage(){
        if (price.isDisplayed()) {
            System.out.println("Ціна товару на сторінці відображається.");
        } else {
            System.out.println("Помилка:Ціна товару на сторінці не відображається.");
        }return this;
}  public MainProductsPage isButtonBasketOnThePage(){
        if (basket.isDisplayed()) {
            System.out.println("Кнопка 'Добавити в корзину 'на сторінці відображається.");
        } else {
            System.out.println("Помилка:Кнопка 'Добавити в корзину 'на сторінці  не відображається.");
        }return this;
    }
    public MainProductsPage chooseSizeJacket(){
     new Select(jacketSize).selectByVisibleText("S");
     return this;
    }

    public MainProductsPage addToBasket(){
        basket.click();
        return  this;
    }}
