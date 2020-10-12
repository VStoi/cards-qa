package org.cards.ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.cards.ui.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class BasePageTest {

    @Test
    public void testSignUpLink() {
        HomePage page = new HomePage();
        page.clickSignUpButton();
        String url = WebDriverRunner.url();
        Assertions.assertEquals("http://localhost:3000/sign-up", url);
    }
}
