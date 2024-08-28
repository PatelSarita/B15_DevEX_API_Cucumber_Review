Feature: Compare UI and API Experiences

  @ui_api_e2e
  Scenario Outline: UI and API Experiences t06
    Given The user sends a POST request and login with "<email>" and "<password>"
    When The user sends a POST request for adding an experience with "<title>" "<company>" "<location>" "<from>" "<to>" "<current>" "<description>"
    Then The user verifies that the status code is <statusCode>
    When The user sends a GET request to get experience by ID
    And The user is on the Dashboard page
    Then The user verifies that UI experience and API experience for the "<company>" should match

    Examples:
      | email            | password   | title  | company | location | from       | to         | current | description | statusCode |
     # | sara4@eurotech.com | test1234 | Tester | Infosys | Germany  | 20-01-1012 | 30-12-2020 | false   | we are done | 201       |
      | professor@lacasadepapel.com | moneyHeist | Professor | Infosys | Germany   | 2009-11-13 | 2021-12-03 | false   | We are done | 201        |