package org.cards.ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.cards.ui.pages.HomePage;
import org.cards.ui.pages.SignUpPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.fillForm("user@test.com",
                "Qwerty11",
                "Qwerty11");
    }
}
