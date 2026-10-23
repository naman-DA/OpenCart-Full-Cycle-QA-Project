Feature: Shopping Cart Tests

  Scenario: Verify adding a simple product to the cart successfully
    Given the user is on a product page
    When the user adds the product to the cart
    Then the product should be added successfully to the shopping cart

  Scenario: Verify validation error when adding a product without selecting a mandatory option
    Given the user is on a product page with required options
    When the user tries to add the product without selecting the mandatory option
    Then a validation error message should be displayed

  Scenario: Verify increasing or decreasing the product quantity in the cart
    Given the user has a product in the shopping cart
    When the user updates the product quantity
    Then the shopping cart should reflect the updated quantity

  Scenario: Verify removing a product from the shopping cart
    Given the user has at least one product in the shopping cart
    When the user removes the product
    Then the product should no longer appear in the cart

  Scenario: Verify the error message when applying an invalid coupon code
    Given the user is on the shopping cart page
    When the user applies an invalid coupon code
    Then an invalid coupon error message should be displayed

  Scenario: Verify cart prices update correctly after changing the active currency
    Given the user is on the shopping cart page
    When the user changes the active website currency
    Then the cart prices should update to reflect the selected currency

  Scenario: Verify the ability to estimate shipping costs from the cart page
    Given the user is on the shopping cart page
    When the user enters location details for shipping estimation
    Then the estimated shipping cost should be displayed

  Scenario: Verify cart contents are preserved after logging out and logging back in
    Given the user is logged in and has products in the cart
    When the user logs out and logs in again
    Then the same cart contents should still be available
