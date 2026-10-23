Feature: Account Management and User Dashboard

  Scenario: Verify updating the Name or Telephone in Account Details
    Given the user is logged in
    When the user updates their Name or Telephone in the Account Details
    Then the updated Name or Telephone should be saved and displayed correctly

  Scenario: Verify updating the Email Address in Account Details
    Given the user is logged in
    When the user updates their Email Address in the Account Details
    Then the updated Email Address should be saved and displayed correctly

  Scenario: Verify successful Password Change from the Account Dashboard
    Given the user is logged in
    When the user changes their account password from the Account Dashboard
    Then a confirmation message should be displayed and the new password should work

  Scenario: Verify adding, deleting, and editing Shipping Addresses in the Address Book
    Given the user is logged in
    When the user adds, edits, or deletes a shipping address in the Address Book
    Then the Address Book should reflect all changes correctly

  Scenario: Verify the Order History page displays the list of all past orders
    Given the user is logged in
    When the user navigates to the Order History page
    Then all past orders should be displayed correctly

  Scenario: Verify subscribing and unsubscribing from the Newsletter
    Given the user is logged in
    When the user subscribes or unsubscribes from the Newsletter
    Then the subscription status should be updated correctly

  Scenario: Verify the Reward Points balance and transactions page
    Given the user is logged in
    When the user navigates to the Reward Points page
    Then the current balance and transaction history should be displayed correctly

  Scenario: Verify the Transactions history page
    Given the user is logged in
    When the user navigates to the Transactions history page
    Then all past transactions should be displayed correctly

  Scenario: Verify access and functionality of the Product Downloads page
    Given the user is logged in
    When the user navigates to the Product Downloads page
    Then all available downloads should be accessible and downloadable
