Feature: Place an order misafir kullanıcı

  @smoke
  Scenario: varsayılan ödeme seçenekleri ile siparis test
    Given im a quest customer
    And my billing details aree
      | firstname | lastname | country            | address_line1     | city  | state | zip   | email              |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | askomdch@gmail.com |
    And i have a porduct in the cart
    And im on the checkout page
    When i provide biling details
    And i place an order
    Then the order should be placed successfuly