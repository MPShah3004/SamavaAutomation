Feature: Search based on address or post code
  As a application user, I want to be able to search restaurant
  based on name of locality and post code

  Background:
    Given Kelly is looking for good restaurants nearby
    And launches "https://www.lieferando.de/"

#  City as a Koln and Postcode that contains 123
  Scenario Outline: Search address based on valid different criteria
    When Kelly searches restaurants by <search_by_option>
    And She selects any of locality
    Then She should get list of restaurants in selected area

    Examples:
      | search_by_option |
      | "PostCode:123"   |
      | "City:Koln"      |


#  Blank Postcode and Invalid city
  Scenario Outline: Search address based on invalid different criteria
    When Kelly searches restaurants by providing invalid <options>
    Then She should not get any options near by locality

    Examples:
      | options                  |
      | "PostCode: "             |
      | "City:YYYYYYYYYYYYYYYYY" |

