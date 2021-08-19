Feature: Edit employee
  Scenario Outline: Edit employee functionality
    Given User is already logged in and he is ready to test edit functionality
    And The employee page is displayed for editing
    When The edit button is clicked
    And The fields are edited with: <name>, <email>, <internalPosition>, <unit>, <businessUnit>, <supervisor>, <workingHours>, <startDate> and <endDate>
    And I click on save changes button
    Then I check if employee was edited
    Examples:
      | name          | email              | internalPosition | unit | businessUnit | supervisor      | workingHours | startDate  | endDate    |
      | Valentin Radu | valentin@yahoo.com | Junior           | U2   | BU2          | Gabriel Popescu |    4         | 09/25/2021 | 10/30/2022 |