package com.samava.web.businessflow;

import com.samava.web.pages.HomePage;
import com.samava.web.pages.PostLoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.samava.web.util.CustomAsserts.assertThat;

public class Login {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    public void loginWithInvalidCredentials(String userName, String password) {
        new HomePage().enterCredentials(userName, password);
    }

    public void checkErrorMessage() {
        assertThat("Error message is not displayed", new PostLoginPage().hasErrorMessage());
    }
}
