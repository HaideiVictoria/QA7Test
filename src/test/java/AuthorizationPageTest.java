import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.MyAllureListener;

@Listeners({MyAllureListener.class})
public class AuthorizationPageTest extends BaseTest{
    @Test
    public void checkAuthorization(){
        clickerPage.openMainPage()
                .acceptCookies()
                .checkIfAreInputFieldsEmailOrPassword()
                .isNotCorrectEmailAdress()
                .userIsRegistered();

    }
}
