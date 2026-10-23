Feature: Product Search

  Scenario: Verify search results for a correct and matching product keyword
    Given the user is on the Home page
    When the user searches for a valid product keyword
    Then the matching products should be displayed in the search results

  Scenario: Verify "No results found" message for a non-existent keyword
    Given the user is on the Home page
    When the user searches for a keyword that does not match any product
    Then a no results message should be displayed

  Scenario: Verify accuracy of search results for case sensitivity
    Given the user is on the Home page
    When the user searches using the same keyword in a different case format
    Then the same relevant search results should be displayed

  Scenario: Verify filtering of search results by price range
    Given the user has performed a product search
    When the user applies a price range filter
    Then the search results should update to show products within that price range

  Scenario: Verify sorting of search results by Product Name A-Z
    Given the user has performed a product search
    When the user applies sorting by product name from A to Z
    Then the search results should display products sorted alphabetically
