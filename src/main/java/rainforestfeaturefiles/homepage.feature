Feature: Rainforest Homepage Tests

  Scenario: Verify the page title
    Given I navigate to the Rainforest homepage
    Then The page title should be RainForest

  Scenario: Check Header Display
    Given I navigate to the Rainforest homepage
    Then The header should display RainForest