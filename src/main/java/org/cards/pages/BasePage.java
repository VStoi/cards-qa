package org.cards.pages;
import org.cards.constants.BaseConstants;

import static com.codeborne.selenide.Selenide.*;


public class BasePage {
    public BasePage(){
        open(BaseConstants.BaseUrl);
    }
}
