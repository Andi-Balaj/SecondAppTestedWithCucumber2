Feature: Add employee

  Scenario Outline: Add employee functionality
    Given User is already logged in
    And The employee page is displayed
    When The add button is clicked
    And The fields are completed with: <name>, <email>, <internalPosition>, <unit>, <businessUnit>, <supervisor>, <workingHours>, <startDate> and <endDate>
    And I click on save button
    Then I check if employee was added
    Examples:
      | name          | email            | internalPosition | unit | businessUnit | supervisor   | workingHours | startDate | endDate  |
      | Marian Andrei | marian@yahoo.com | Junior           | U1   | BU1          | Radu George  | 6            | 5/25/2021 | 5/25/2022|
      | Vlad Mihai    | vlad@yahoo.com   | Junior           | U2   | BU2          | Razvan Matei | 8            | 6/14/2021 | 9/20/2021|
      | Marc Anton    | marc@yahoo.com   | Junior           | U1   | BU1          | Mihai Iacob  | 4            | 7/25/2021 | 8/25/2021|