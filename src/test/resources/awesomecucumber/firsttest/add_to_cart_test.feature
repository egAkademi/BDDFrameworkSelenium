Feature: Add to cart test

  @smoke
  Scenario: add one quantity from Store test test
    Given I'm on the Store Page
    When I add a "Blue Shoes" too the cart
    Then I should see 1 "Blue Shoes" inn the cart

  @smoke
  Scenario Outline: add one quantity from Store test test multiple - examples
    Given I'm on the Store Page
    When I add a "<product_name>" too the cart
    Then I should see 1 "<product_name>" inn the cart
    Examples:
      | product_name                    |
      | Anchor Bracelet                 |
      | Black Over-the-shoulder Handbag |