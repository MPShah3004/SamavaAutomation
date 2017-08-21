package com.lieferando.web.businessflow;

import com.lieferando.web.pages.HomePage;
import com.lieferando.web.pages.SearchResultPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.lieferando.web.util.CustomAsserts.assertThat;


public class SearchRestaurants {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    public void searchRestaurantsIn(String searchString) {
        LOGGER.debug("Navigating to Home and searching for " + searchString);
        assertThat("Invalid Page title",
                new HomePage().getPageTitle().equalsIgnoreCase("Lieferando.de | Essen bestellen - Pizza bestellen"));
        new HomePage().searchForRestaurants(searchString);
    }

    public void selectRandomLocalityFromList() {
        LOGGER.debug("Selecting random restaurant from list");
        new HomePage().selectOptionsFromList();
    }

    public void verifyListOfRestaurants() {
        LOGGER.debug("Verifying valid list of restaurants");
        assertThat("Search restaurants failed", new SearchResultPage().hasListOfRestaurants());
        assertThat("Invalid Page title",
                new SearchResultPage().getPageTitle().toLowerCase().contains("Lieferservice in".toLowerCase()));
    }

    public void verifySearchRecommendations() {
        LOGGER.debug("Verifying that no search result for enter criteria");
        assertThat("Should not have options", new HomePage().notHaveRecommendations());
    }
}
