package org.cards.ui.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage {
    private final By emailField = By.xpath("//input[@name=\"email\"]");
    private final By passwordField = By.xpath("//input[@name=\"password\"]");
    private final By confirmPasswordField = By.xpath("//input[@name=\"confirmPassword\"]");

    public void fillForm(String email, String password, String confirmPassword) {
        $(emailField).setValue(email);
        $(passwordField).setValue(password);
        $(confirmPasswordField).setValue(confirmPassword);
    }
}
