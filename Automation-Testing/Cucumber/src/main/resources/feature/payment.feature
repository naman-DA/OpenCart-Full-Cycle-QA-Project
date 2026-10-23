Feature: Payment Functionality

  Scenario: Complete payment with valid login
    Given user is logged in with "m2@gmail.com" and "0000"
    And product "iPod Classic" is in cart
    When user selects existing address
    And selects shipping method "Flat Shipping Rate - $8.00"
    And selects payment method "Cash On Delivery"
    And clicks confirm order
    Then order should be placed successfully

  Scenario: Payment without selecting shipping method
    Given user is logged in with "m2@gmail.com" and "0000"
    And product "iPod Classic" is in cart
    When user leaves shipping method empty
    And selects payment method "Cash On Delivery"
    And clicks confirm order
    Then error message "Shipping method required!" is displayed

  Scenario: Payment without selecting payment method
    Given user is logged in with "m2@gmail.com" and "0000"
    And product "iPod Classic" is in cart
    When user selects shipping method "Flat Shipping Rate - $8.00"
    And leaves payment method empty
    And clicks confirm order
    Then error message "Payment method required!" is displayed