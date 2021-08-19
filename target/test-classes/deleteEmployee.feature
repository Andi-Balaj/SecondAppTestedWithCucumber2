Feature: Delete employee

  Scenario: Delete employee functionality
    Given User is already logged in on the application
    When The employee page is displayed for deleting employees
    And The delete button is clicked
    Then I check if employees were deleted
