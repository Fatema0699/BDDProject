@Shop
Feature: Shop Page Tests

  @shoptest1
  Scenario: Verify Shop Links Functionality
    Given I navigate to the Shop page
    When I click on Shop 1
    Then a new tab with URL "https://www.example1.com/" should open
    When I click on Shop 2
    Then again a new tab with URL "https://www.example2.com/" should open

  @shoptest2
  Scenario: Validate that clicking "Shop 3" and "Shop 4" displays the correct alert messages
    Given I navigate to the Shop page
    When I click on Shop 3
    Then an alert for shop3 should display the message "You are entering the Shop 3 shop!"
    When I click on Shop 4
    Then an alert for shop4 should display the message "You are entering the Shop 4 shop!"

  @QueryModalOpening
  Scenario: Submit a Query button opens the modal popup
    Given I navigate to the Shop page
    When I click on Submit a query button
    Then a modal appears with a text area and a Close button

  @QueryModelClosing
  Scenario: Ensure the modal closes using the Close button or Submit button
    Given I navigate to the Shop page
    When  I click on Submit a query button to open the modal
    And I click on Close button
    Then the modal should close successfully
    When I click on Submit a query to reopen
    And I click on Submit button
    Then the modal should close again successfully

  @BacktoHome
  Scenario: Back to Home Link Navigation
    Given I navigate to the Shop page
    When I click on the Back to home link at the bottom of the shop page
    Then I should redirected to the homepage "https://monsur26.github.io/mypage/index.html"

