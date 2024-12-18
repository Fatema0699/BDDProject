Feature: Rainforest Homepage Tests

  Scenario: Verify the page title
    Given I navigate to the Rainforest homepage
    Then The page title should be RainForest

  Scenario: Check Header Display
    Given I navigate to the Rainforest homepage
    Then The header should display RainForest

  Scenario: Navigation bar links
    Given I navigate to the Rainforest homepage
    When I click on the Home link
    Then I should be redirected to the homepage "https://monsur26.github.io/mypage"

    When I click on the Shop link
    Then I should be redirected to the shoppage "https://monsur26.github.io/mypage/shop"

    When I click on the Contact link
    Then I should be redirected to the contactpage "https://monsur26.github.io/mypage/contact"