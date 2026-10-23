Feature: Product and Category Pages Validation

  Scenario: Verify a category page loads and displays its associated products
    Given the user is on a category page
    When the category page is opened
    Then the category products should be displayed

  Scenario: Verify pagination works correctly for categories with many products
    Given the user is on a multi-page category
    When the user navigates to the next page
    Then the next set of category products should be displayed

  Scenario: Verify product page shows all mandatory information
    Given the user is on a product details page
    When the product page loads
    Then the product name price image and description should be displayed

  Scenario: Verify product thumbnails and main image zoom functionality
    Given the user is on a product details page
    When the user interacts with the product images
    Then the image zoom and thumbnail switching should work correctly

  Scenario: Verify the product price updates dynamically when selecting options
    Given the user is on a product page with selectable options
    When the user selects different product options
    Then the product price should update dynamically

  Scenario: Verify product reviews section is displayed
    Given the user is on a product details page
    When the user scrolls to the reviews section
    Then existing customer reviews should be displayed

  Scenario: Verify submitting a new product review
    Given the user is on a product details page
    When the user submits a valid product review
    Then the review submission confirmation should be displayed

  Scenario: Verify adding a product to the wishlist for a logged-in user
    Given the user is logged in and is on a product page
    When the user adds the product to the wishlist
    Then the product should be added to the wishlist successfully

  Scenario: Verify adding products to comparison and comparing items
    Given the user is on home page
    When the user adds multiple products to the comparison list
    Then the comparison page should display the selected products

  Scenario: Verify special prices and discount percentages displayed correctly
    Given the user is on a product or category page with discounted items
    When the product prices are displayed
    Then the special price and discount percent should appear correctly
