Feature: Rainforest Homepage Tests
@firsttest
  Scenario: Verify the page title
    Given I navigate to the Rainforest homepage
    Then The page title should be "RainForest"