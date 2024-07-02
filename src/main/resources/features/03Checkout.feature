Feature: Checkout Product

  Scenario: Successfully checkout a product
    Given I logged in to the application
    When I add new product to the cart
    And I proceed to checkout
    And I provide valid checkout information
    And I finish the checkout process
    Then I should see the order confirmation page