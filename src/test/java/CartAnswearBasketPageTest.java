import org.testng.Assert;
import org.testng.annotations.Test;

public class CartAnswearBasketPageTest extends BaseTest{
    @Test
    public void checkBasketCart(){
        int countOfTimes= 2;
        cartAnswearBasketPage
                .openJacketPage()
                .acceptCookiesJacketPage()
                .addToBasket()
                .size()
                .isBasketIconOnThePage()
                .basketIconOpen()
                .clickOnPlusCountOfTimes(countOfTimes)
                .isDeleteOnThePage()
                .isButtonBuyOnThePage();
                //.buy();

        Assert.assertEquals(cartAnswearBasketPage.returnResult(), countOfTimes);
    }
}
