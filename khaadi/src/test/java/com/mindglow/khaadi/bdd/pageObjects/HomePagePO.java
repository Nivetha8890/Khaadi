package com.mindglow.khaadi.bdd.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static com.mindglow.khaadi.bdd.support.WebConnector.*;

import java.util.List;


public class HomePagePO {

    @FindBy(css = "#cd-dropdown")
    private WebElement countryDropdown;

    @FindBy(css = ".home-button")
    private WebElement enterButton;

    @FindBy(css = ".show-search")
    private WebElement showSearch;

    @FindBy(css = "#close_pop_up")
    private WebElement closePopUp;

    @FindBy(css = ".row-container #search")
    private WebElement search;
    
    @FindBy(css = ".product-name a")
    private List<WebElement> productName;

    public static String homePageUrl() {
        return getHost() + "/home.php";
    }

    public void navigateToHomePage() {
        driver.get(homePageUrl());
    }

    public void selectCountryAndClickEnter() {
        Select country = new Select(countryDropdown);
        country.selectByVisibleText("India");
        enterButton.click();
    }

    public void clickOnShowSearch() {
        waitForElement(10).until(ExpectedConditions.elementToBeClickable(showSearch));
        showSearch.click();
    }

    public void clickOnClosePopUp() {
        waitForElement(10).until(ExpectedConditions.elementToBeClickable(closePopUp));
        closePopUp.click();
    }

    public void searchKeyword(String keyword) {
        waitForElement(10).until(ExpectedConditions.visibilityOf(search));
        search.sendKeys(keyword);
        search.submit();
    }
    public void assertSearchResultProductsTitle()
    {
    String expectedResult = "Handbag";
    for(WebElement title: productName)
    {
    String actualResult = title.getText();
    Assert.assertEquals(expectedResult, actualResult);
    }
    }
}
