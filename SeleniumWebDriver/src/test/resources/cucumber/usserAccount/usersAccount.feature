@UserAccount
Feature:Register Process
  As user of YourLogo
  i want to register and access to the page

  Background:Go to the Homepage of YourLogo
    Given The user goes to the HomePage

  @severity=minor
  Scenario: Logging successful with user already existing
    And The user clicks the button of Sing In
    When The user set your credentials
    And The user clicks the button for submit email and password
    Then The user is logged in
