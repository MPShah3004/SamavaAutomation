Feature: Search for loan
  As a application user, I want to be able to search for loan
  based on tenure and purpose

#    Amount is in euro,duration is in months
  Scenario Outline: Search for loan for various purpose
    Given Kelly is looking for loan
    And launches "https://www.smava.de/"

    When Kelly searches for loan for <amount> with repayment <duration> for <purpose>
    And She select any from available options
    Then She should get detail information for selected one

    Examples:
      | amount | duration | purpose  |
      | 2750   | 24       | "Wohnen" |


