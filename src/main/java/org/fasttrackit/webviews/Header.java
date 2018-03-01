package org.fasttrackit.webviews;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(id = "select-language")
    private WebElement languageDropDownList;

    public void search(String keyword) {
        searchField.sendKeys(keyword + Keys.ENTER);
        System.out.println("Pressed Enter in search field.");
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getLanguageDropDownList() {
        return languageDropDownList;
    }
}
