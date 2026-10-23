Feature: Checkout Functionality

  Scenario: Checkout without login
    Given user is on homepage
    When user clicks on Checkout icon
    Then shopping cart page should appear with message "Your shopping cart is empty!

  Scenario: Checkout with valid login and valid details
    Given user is on homepage
    And user is logged in with "m2@gmail.com" and "0000"
    And product "iPod Classic" is added to cart
    When user clicks on Checkout icon
    And user proceeds to checkout with new address
    And fills first name "Mohamed"
    And fills last name "Hassan"
    And fills address1 "123 Street"
    And fills city "Cairo"
    And selects country "Egypt"
    And selects region "Cairo"
    And clicks continue
    Then user should proceed to payment page

  Scenario: Checkout with invalid first name
    Given user is on homepage
    And user is logged in with "m2@gmail.com" and "0000"
    And product "iPod Classic" is added to cart
    When user clicks on Checkout icon
    And user proceeds to checkout with new address
    And fills first name "Mohamed123"
    And clicks continue
    Then error message "First Name must consist of characters only" is displayed

  Scenario: Guest checkout with valid details
    Given user is on homepage
    And product "iPod Nano" is added to cart
    When user clicks on Checkout icon
    And user selects Guest Checkout
    And fills all required data correctly
    And clicks continue
    Then user should proceed to payment page
