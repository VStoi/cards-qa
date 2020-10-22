package org.cards.ui.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class HomePage extends BasePage {

    private final By signUpButton = By.xpath("//a[@href=\"/sign-up\"]");
    private final By signInButton = By.xpath("//a[@href=\"/sign-in\"]");

    public void clickSignUpButton(){
        $(signUpButton).shouldBe(visible).click();
    }

    public void clickSignInButton(){
        $(signInButton).shouldBe(visible).click();
    }

}
