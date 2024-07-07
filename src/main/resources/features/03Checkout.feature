Feature: Checkout Product

  Scenario: Successfully checkout a product
    Given I logged in to the application
    When I add new product to the cart
    And I proceed to checkout
    And I provide valid checkout information
    And I finish the checkout process
    Then I should see the order confirmation page


  Scenario: Failed checkout Product not input firstname
    Given I click back home
    When I add new product to the cart
    And I proceed to checkout
    And I provide invalid firstname checkout information
    Then I should see an error message firstname

  Scenario: Failed checkout Product not input lastname
    And I provide invalid lastname checkout information
    Then I should see an error message lastname

  Scenario: Failed checkout Product not input postal code
    And I provide invalid postal code checkout information
    Then I should see an error message postal code