package com.samava.web.businessflow;

import com.samava.web.pages.HomePage;
import com.samava.web.pages.LoanOptionPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.samava.web.util.CustomAsserts.assertThat;

public class SearchLoan {
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    public void selectLoanFor(Integer amount, Integer duration, String purpose) {
        new HomePage().enterSearchCriteria(amount, duration, purpose);
    }

    public void getDifferentBanks() {
        new HomePage().clickOnNext();
    }

    public void checkPageIsLoaded() {
        assertThat("Page is not loaded", new LoanOptionPage().isPageLoaded());
    }
}
