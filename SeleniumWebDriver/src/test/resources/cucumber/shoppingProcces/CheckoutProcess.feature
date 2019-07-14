@CheckoutProcess
Feature: Checkout Process
  As user of YourLogo
  i want to do the checkout process

  Background: The user has been authenticated with almost one address
    Given The user goes to the HomePage
    And The user adds any product
    And The user goes to the Checkout Page
  @severity=blocker
  Scenario: Checkout Successful
    When The user check the summary checkout
    And The user set your credentials
    And The user clicks the button for submit email and password
    And The user check the address
    And The user check the Terms of the service
    And The user set any payment method
    Then The process of checkout is completed

  @severity=blocker
   Scenario Outline: Checkout Successful with different quantity of product
     When The user edits the quantity before for <quantity> products of the same type chose
     And The user check the summary checkout
     And The user set your credentials
     And The user clicks the button for submit email and password
     And The user check the address
     And The user check the Terms of the service
     And The user set any payment method
     Then The process of checkout is completed
     Examples:
     |quantity  |
     |   30     |
     |   1000   |
     |429496729 |