package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGrid {

    @FindBy(css = ".product-name a")
    private List<WebElement> productNames;

    public List<WebElement> getProductNames() {
        return productNames;
    }
}
