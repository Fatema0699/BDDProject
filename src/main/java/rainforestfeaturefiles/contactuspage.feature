Feature: Form Validation for Required Fields
@ContactPage1stTest
  Scenario: Validate that all form fields are required
    Given I navigate to the Rainforest Contact page
    When the user leaves the Name, Email, and Message fields empty
    And  clicks on the Submit button
    Then I should see all required fields highlighted
    And the form should not be submitted