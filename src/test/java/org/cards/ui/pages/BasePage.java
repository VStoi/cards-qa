package org.cards.ui.pages;
import org.cards.ui.constants.BaseConstants;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class BasePage {
    public BasePage(){
        open(BaseConstants.BaseUrl);
    }
}
