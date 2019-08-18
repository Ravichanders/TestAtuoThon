Feature: Second Test

  Scenario: verify preference value
  	Given I am at the home page
    When  I click "Preference" option
    And   I click on "Launch Preference Activity"
    Then  I capture counter preference value
    And   I verify counter preference value is "50"
    