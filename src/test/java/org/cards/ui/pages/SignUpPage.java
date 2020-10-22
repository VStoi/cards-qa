package org.cards.ui.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class SignUpPage {
    private final By emailField = By.xpath("//input[@name=\"email\"]");
    private final By passwordField = By.xpath("//input[@name=\"password\"]");
    private final By confirmPasswordField = By.xpath("//input[@name=\"confirmPassword\"]");
    private final By signUpPageButton = By.xpath("//button[text()=\"Sign Up\"]");
    private final By tokenField = byText("token");


    public void fillForm(String email, String password, String confirmPassword) {
        $(emailField).setValue(email);
        $(passwordField).setValue(password);
        $(confirmPasswordField).setValue(confirmPassword);
        $(signUpPageButton).click();
    }

    public void fillTokenAndSubmit(String token) {
        $(tokenField).setValue(token);
    }
}
