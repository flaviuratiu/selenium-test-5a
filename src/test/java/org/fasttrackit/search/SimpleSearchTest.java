package org.fasttrackit.search;

import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.Header;
import org.fasttrackit.webviews.ProductsGrid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class SimpleSearchTest extends TestBase {

    private String keyword;

    public SimpleSearchTest(String keyword) {
        this.keyword = keyword;
    }

    @Parameterized.Parameters
    public static List<String> inputData() {
        return Arrays.asList("vase");
    }

    @Test
    public void simpleSearchWithOneKeyword() {
        Header header = initElements(Header.class);

        header.search(keyword);
        ProductsGrid productsGrid = initElements(ProductsGrid.class);
        System.out.println("Stored " + productsGrid.getProductNames().size() + " product names from search results.");

        for (WebElement productName : productsGrid.getProductNames()) {
            assertThat("Some of the product names do not contain the searched keyword.",
                    productName.getText(), containsString(keyword.toUpperCase())
            );
        }
    }

    @Test
    public void specialPriceDisplayedAfterSimpleSearch() {
        driver.findElement(By.id("search")).sendKeys("vase" + Keys.ENTER);

        String oldPrice = driver.findElement(By.xpath("//p[@class='old-price']//span[@class='price']")).getText();
        String specialPrice = driver.findElement(By.xpath("//p[@class='special-price']//span[@class='price']")).getText();

        String oldPriceValue = oldPrice.split(" ")[0]
                .replace(",", ".");

        String specialPriceValue = specialPrice.split(" ")[0]
                .replace(",", ".");

//        assertThat("Old price greater than special price",
//                Double.parseDouble(oldPriceValue),
//                is(lowerThan(Double.parseDouble(specialPriceValue)))
//                );

    }

}
