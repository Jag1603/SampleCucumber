Feature: feature to test login functionality

  Scenario: To check whether the login Functionality of application is working or not
    Given user is on login page
    When user enters username and password
    And user clicks submit button
    Then user should be to login succesfully
