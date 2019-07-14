@ProductManagement
Feature: Product Management
  As user of YourLogo
  i want to do shopping process

  Background: The user has been authenticated with almost one address
    Given The user goes to the HomePage
  @severity=blocker
  Scenario: Add product
    When The user adds any product
    Then The product is in the shopping cart
  @severity=blocker
  Scenario: Add more than one product from the HomePage
    When The user adds 3 products
    Then The user can see the products in the shopping cart
  @severity=critical
  Scenario: Remove product type in the Shopping cart from Home Page
    Given The user has added almost one product to the shopping cart
    When The user deletes the product from the shopping cart
    Then The product has been remove
  @severity=trivial
  Scenario: View description from a product from the Home Page
    And The user chooses a product
    When The user open the quickView of the product
    Then The user can see the description about the product;
  @severity=blocker
  Scenario: Add product from detail product Page
    And The user chooses a product
    And The opens the details page of the product chose
    When The user adds the product
    Then The user can see the products in the shopping cart
  @severity=normal
  Scenario: View products chose from Summary Checkout
    And The user adds any product
    When The user goes to the Checkout Page
    Then The product can see in the Summary Checkout Page
  @severity=critical
  Scenario: add more products of the same type chose
    And The user adds any product
    And The user goes to the Checkout Page
    When The user edits the quantity before for 3 products of the same type chose
    Then The quantity of product has increased
  @severity=critical
  Scenario: Delete all products of the same type chose
    And The user adds any product
    And The user goes to the Checkout Page
    When The user deletes all products of the same type
    Then The product of the same type is delete from the Summary Checkout Page