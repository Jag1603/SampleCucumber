Feature: feature to test login functionality

  Scenario Outline: Validate login with different data sets
    Given user is on login page
    When user enters username "<username>" and password "<password>"
    And user clicks submit button
    Then user should be able to login successfully with status "<status>"

    Examples:
      | username       | password      | status   |
      | validuser      | validpass     | success  |
      | admin          | admin123      | success  |
      | invaliduser    | wrongpass     | failure  |
      | testuser       | testpass      | failure  |
