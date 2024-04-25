package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorizationPage extends BasePage {
    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }
@FindBy(xpath ="//*[@id=\"_username\"]")
    private WebElement userName;

    @FindBy(xpath ="//*[@id=\"_password\"]")
    private WebElement password;
    @FindBy(xpath ="//button[@type='submit']")
    private WebElement exit;
    @FindBy(xpath ="/html/body/div[2]/div/div/div/div[2]/button")
    private WebElement acceptCookies;

    static final Logger logger = LoggerFactory.getLogger(AuthorizationPage.class);
    public AuthorizationPage openMainPage(){
        driver.get(constans.Url.CLICKER_ANSWEAR_PAGE);
        return  this;
    }
    public AuthorizationPage acceptCookies(){
            workWithElement.click(acceptCookies);

        return this;
    }
    public AuthorizationPage checkIfAreInputFieldsEmailOrPassword() {
        if (userName.isDisplayed() && password.isDisplayed()) {
            System.out.println("Поле для вводу EMAIL та PASSWORD є на сторінці");
        } else {
            System.out.println("Поле для вводу EMAIL та PASSWORD відсутні на сторінці");
        }return this;

    }
    public AuthorizationPage isNotCorrectEmailAdress(){
        userName.sendKeys("12345678");
        password.sendKeys("12345678");
        exit.click();

        if (userName.isDisplayed() && userName.getText().contains("Будь ласка, введіть електронну адресу правильно")) {
            System.out.println("Будь ласка, введіть електронну адресу  правильно");
        } else {
            System.out.println("Помилка :не відображається текст :Будь ласка, введіть електронну адресу чи пароль правильно");


    }

        return this;
    }

    public AuthorizationPage userIsRegistered(){
        userName.clear();
        password.clear();
        userName.sendKeys("victoria_haidei@ukr.net");
        password.sendKeys("ryswyv-Fifcij-0behke");
        exit.click();
        if (driver.getCurrentUrl().equals("Користувач переходить на основну сторінку сайту https://answear.ua/mii-akkaunt")) {
            System.out.println("Користувач зареєсторований на сайті");
        } else {
            System.out.println("Помилка:такого користувача не знайдено");
        }
        logger.info("Enter the users Email address and password");
        return this;
    }
}
// span.fieldError.FieldError__error__ZiVkd