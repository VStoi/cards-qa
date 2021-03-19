package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.cards.db.verification_tokens.VerificationTokensDB;
import org.cards.pages.HomePage;
import org.cards.pages.SignUpPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class BasePageTest {

    @Test
    public void testSignUpLink() {
        HomePage page = new HomePage();
        page.clickSignUpButton();
        String url = WebDriverRunner.url();
        assertEquals("http://localhost:3000/sign-up", url);
    }

    @Test
    public void testFormFill() {
        open("http://localhost:3000/sign-up");
        SignUpPage page = new SignUpPage();
        page.fillForm("user@test.com",
                "Qwerty11",
                "Qwerty11");
        VerificationTokensDB db = new VerificationTokensDB("user@test.com");
        page.fillTokenAndSubmit(db.getToken());
        String url = WebDriverRunner.url();
        assertEquals("http://localhost:3000/sign-in", url);
    }
}
