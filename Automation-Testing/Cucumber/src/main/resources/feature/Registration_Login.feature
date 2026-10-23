Feature: Registration & Login

  Scenario: Verify successful registration with all optional fields
    Given the user is on the Registration page
    When the user submits the registration form with all mandatory and optional fields filled correctly

  Scenario: Verify error message when First Name field is empty
    Given the user is on the Registration page
    When the user submits the registration form without entering a First Name
    Then an error message should appear indicating the First Name is required

  Scenario: Verify error message for invalid email address format
    Given the user is on the Registration page
    When the user enters an invalid email format and submits the registration form

  Scenario: Verify error message when registering with an existing email
    Given the user is on the Registration page
    When the user submits the registration form using an already registered email
    Then an error message should appear indicating the email is already registered

  Scenario: Verify the Privacy Policy checkbox is not selected by default
    Given the user is on the Registration page
    When the user views the Privacy Policy checkbox
    Then the checkbox should not be selected by default

  Scenario: Verify error message when Privacy Policy is not agreed
    Given the user is on the Registration page
    When the user submits the registration form without agreeing to the Privacy Policy
    Then an error message should appear indicating agreement is required

  Scenario: Verify successful login with valid credentials
    Given the user is on the Login page
    When the user enters valid login credentials and submits the form
    Then the user should be logged in successfully

  Scenario: Verify error message for invalid password
    Given the user is on the Login page
    When the user enters a valid email and an invalid password
    Then an error message should appear indicating invalid login details

  Scenario: Verify error message for unregistered email
    Given the user is on the Login page
    When the user enters an unregistered email and any password
    Then an error message should appear indicating the email is not found

  Scenario: Verify functionality of the Forgotten Password link
    Given the user is on the Login page
    When the user clicks the Forgotten Password link
    Then the user should be redirected to the password reset page

  Scenario: Verify successful logout
    Given the user is logged into their account
    When the user clicks the Logout option
    Then the user should be logged out and see a logout confirmation message

  Scenario: Verify access to the My Account page after login
    Given the user is logged in with valid credentials
    When the user navigates to the My Account page
    Then the My Account page should be displayed successfully
