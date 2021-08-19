Feature: Add project

  Scenario Outline: Add project functionality
    Given User is already logged in for adding a new project
    And The main page is displayed
    When The add project button is clicked
    And The fields project are completed with: <name>, <client>, <startDate>, <endDate>, <description>
    And I click on save project button
    Then I check if the project was added
    Examples:
      | name          | client        | startDate  | endDate    | description                                                      |
      | Project1      | Justin Dallas | 08/05/2021 | 10/05/2021 | The goal is trying to improve the website.                       |
      | Project2      | Waylon Darby  | 09/15/2021 | 10/15/2021 | The goal is to improve some functionalities of the application.  |
      | Project3      | Leroi Darrell | 09/23/2021 | 09/23/2022 | The goal is to improve security and interface of the application.|