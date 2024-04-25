import org.testng.annotations.Test;

public class MainProductsPageTest extends BaseTest{
    @Test
public void checkProductsPage(){
    mainProductsPage
        .openMainProductsPage()
            .acceptCookies()
            .productSearchOmThePage()
            .openJacketPage()
           .isPriceOnThePage()
           .isButtonBasketOnThePage();

    }
}
