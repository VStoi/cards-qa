package org.cards.ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class HomePage extends BasePage {
    public HomePage() {
        super();
    }

    private final SelenideElement signUpButton = $(By.xpath("//a[@href=\"/sign-up\"]")).shouldBe(visible);

    public void clickSignUpButton(){
        signUpButton.click();
    }

}
