Feature: Login
  As an application user, I want to be able to login to system


  Scenario: Login with invalid credentials
    Given Kelly is looking for loan
    And launches "https://www.smava.de/"

    When Kelly entered invalid credential
    Then She should not allow to access the system