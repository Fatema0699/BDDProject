Feature: Shop Page Tests
@shoptest1
  Scenario: Verify Shop Links Functionality
    Given I navigate to the Shop page
    When I click on Shop 1
    Then a new tab with URL "https://www.example1.com" should open
    When I click on Shop 2
    Then again a new tab with URL "https://www.example2.com" should open