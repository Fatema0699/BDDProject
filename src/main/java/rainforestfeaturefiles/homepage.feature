@Homepagetests
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
    Then I should be redirected to the homepage "https://monsur26.github.io/mypage/#"
    When I click on the Shop link
    Then I should be redirected to the shoppage "https://monsur26.github.io/mypage/shop.html"
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
    And  User clicks on the Login button
    Then the browser should highlight the required fields

  @invaliduser
  Scenario: Login Form Invalid Credentials
    Given I navigate to the Rainforest homepage
    When User clicks and enters invalid username on the username field
    And User clicks and enters invalid password on the password field
    When User clicks on the Login button
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
    When I select "<item>" from the dropdown
    Then I should able to see "<message>" displayed

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
    Then I should be able to see "<message>" displayed

    Examples:
      | item   | message              |
      | Jaguar | You selected: Jaguar |
      | Sloth  | You selected: Sloth  |

  @Checkboxtest
  Scenario: Validate multiple checkbox selections display the correct message
    Given I navigate to the Rainforest homepage
    When I select Medicinal Plants and Timber checkboxes
    Then A valid message "You selected: Medicinal Plants, Timber" should displayed

  @UnCheckboxtest
  Scenario: Validate message when all checkboxes are deselected
    Given I navigate to the Rainforest homepage
    When I select Medicinal Plants and Timber checkboxes
    And I deselect all checkboxes
    Then A message "No resources selected." should displayed

  @Datepicker
  Scenario: Validate date selection updates the displayed message
    Given I navigate to the Rainforest homepage
    When I select "12/21/2024" from the date picker
    Then I should see the "You selected: 2024-12-21"

  @Interactivetable1
  Scenario: Click on "Rainforest Name" column to sort
    Given I navigate to the Rainforest homepage
    When I click on the Rainforest Name column header
    Then the Rainforest Name column should be sorted alphabetically

  @Interactivetable2
  Scenario: Type "Amazon" in the filter input to see the data
    Given  I navigate to the Rainforest homepage
    When I type "Amazon" in the filter input
    Then only rows containing "Amazon" should be displayed

  @CustomAlertOK
  Scenario: Confirming a custom alert
    Given  I navigate to the Rainforest homepage
    When I click on the Click me for a custom alert! button
    And I confirm the custom alert
    Then I should see a message "You clicked OK!"

  @CustomAlertCancel
  Scenario: Cancelling a custom alert
    Given  I navigate to the Rainforest homepage
    When I click on the Click me for a custom alert! button
    And I cancel the custom alert
    Then I should see a message "You clicked Cancel!"

  @videoplayertest1
  Scenario: Video playing functionalities
    Given  I navigate to the Rainforest homepage
    When I click on video toggle button
    Then I should see the video section
    When I play the video
    Then the video should play without errors

  @videoplayertest2
  Scenario: Play and pause video functionalities
    Given  I navigate to the Rainforest homepage
    When I click on video toggle button
    Then I should see the video section
    When I play the video
    Then the video should play without errors
    When I pause the video
    Then the video should pause without errors
    When I again play the video
    Then the video should play without errors

  @iframetest1
  Scenario: Verify iframe content is loaded correctly
    Given I navigate to the Rainforest homepage
    When I click on the iframe toggle button to display the iframe
    Then the iframe should become visible
    And I switch focus to the iframe
    Then I validate that the iframe content is correctly loaded

  @iframetest2
  Scenario: Verify iframe content is loaded correctly
    Given I navigate to the Rainforest homepage
    When I click on the iframe toggle button to display the iframe
    Then the iframe should become visible
    And I switch focus to the iframe
    Then I validate that the iframe content is correctly loaded
    When I switch back to main page
    Then I validate that the mainpage content is correctly loaded

  @HorizontalScroller
  Scenario: Verify horizontal scrolling with Next and Previous buttons
    Given I navigate to the Rainforest homepage
    When I click on the Image section toggle button to display the iframe
    Then the scroller section should become visible
    And I click on the Next button
    Then the images should change correctly
    When I click on the Previous button
    Then the images should change correctly

  @HorizontalScroller1
  Scenario: Verify horizontal scrolling with Next and Previous buttons
    Given I navigate to the Rainforest homepage
    When I click on the Image section toggle button to display the iframe
    Then the scroller section should become visible
    When I click on the image
    Then the images should change correctly

  @DragandDrop
  Scenario: Add a new card
    Given I navigate to the Rainforest homepage
    When I enter "Test Card" as the title
    And I click the Add Card button
    Then the new card with the title Test Card should be added to the container