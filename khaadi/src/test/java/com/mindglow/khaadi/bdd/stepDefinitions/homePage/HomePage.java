package com.mindglow.khaadi.bdd.stepDefinitions.homePage;

import com.mindglow.khaadi.bdd.pageObjects.HomePagePO;
import com.mindglow.khaadi.bdd.support.WebConnector;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    HomePagePO homePagePO = PageFactory.initElements(WebConnector.driver, HomePagePO.class);

    @Given("^I go to Khaadi home page$")
    public void i_go_to_Khaadi_home_page() throws Throwable {
        homePagePO.navigateToHomePage();
        homePagePO.selectCountryAndClickEnter();
    }

    @When("^I see the Khaadi search$")
    public void i_see_the_Khaadi_search() throws Throwable {
        homePagePO.clickOnClosePopUp();
        homePagePO.clickOnShowSearch();
    }

    @When("^I type \"([^\"]*)\"$")
    public void i_type(String search_term) throws Throwable {
        homePagePO.searchKeyword(search_term);
    }

    @Then("^I should see the handbags in search results$")
    public void i_should_see_the_handbags_in_search_results() throws Throwable {
    	homePagePO.assertSearchResultProductsTitle();
    }
}
