Feature: feature to test login functionality

  Scenario Outline: Validate login with different datasets and status
    Given user is on login page
    When user enters username "<username>" and password "<password>"
    And user clicks submit button
    Then user should be able to login successfully with status "<status>"

    Examples:
      | username                    | password      | status  |
      | standard_user               | secret_sauce  | success |
      | performance_glitch_user     | secret_sauce  | success |
      | locked_out_user             | secret_sauce  | failure |
      | standard_user               | wrong_pass    | failure |
