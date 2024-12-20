Feature: Rainforest Homepage Tests

  @GeneralpageRendering
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
    When I click on the Back to home link
    Then I should be back to the homepage "https://monsur26.github.io/mypage/index.html"
    When I click on the Contact link
    Then I should be redirected to the contactpage "https://monsur26.github.io/mypage/contact.html"

  @Formvalidations
  Scenario: Login Form Valid Credentials
    Given I navigate to the Rainforest homepage
    When User clicks and enters valid username on the username field
    And User clicks and enters valid password on the password field
    When User clicks on the Login button
    Then User is successfully logged in

  @emptyusercred
  Scenario: Login form empty input validation
    Given I navigate to the Rainforest homepage
    When the user leaves the username and password fields blank
    And clicks the login button
    Then the browser should highlight the required fields

  @invaliduser
  Scenario: Login Form Invalid Credentials
    Given I navigate to the Rainforest homepage
    When User clicks and enters invalid username on the username field
    And User clicks and enters invalid password on the password field
    When User click on the Login button
    Then User should see an Error message

  @clearform
  Scenario: Cancel button clears form
    Given I navigate to the Rainforest homepage
    When User clicks and enters username on the username field
    And User clicks and enters password on the password field
    When User click on the Cancel button
    Then the fields should be clear out

  @Dropdowntest
  Scenario: Validate dropdown selection displays the correct message
    Given I navigate to the Rainforest homepage
    When I select Congo Rainforest from the dropdown
    Then I should see "You selected: Congo" displayed

  @DynamicDropdown
  Scenario Outline: Validate dropdown selection displays the correct message
    Given I navigate to the Rainforest homepage
    When I select <item> from the dropdown
    Then I should able to see <message> displayed

    Examples:
      | item     | message                |
      | Congo    | You selected: Congo    |
      | Daintree | You selected: Daintree |

  @Radiobtntest
  Scenario: Validate Jaguar radio button displays the correct message
    Given I navigate to the Rainforest homepage
    When I select the Jaguar radio button
    Then I should see You selected: Jaguar displayed

  @MultipleRadiobtntest
  Scenario Outline: Validate Multiple radio button selections
    Given I navigate to the Rainforest homepage
    When I select <item> from the radio button section
    Then I should be able to see <message> dispalyed

    Examples:
      | item   | message              |
      | Jaguar | You selected: Jaguar |
      | Sloth  | You selected: Sloth  |



