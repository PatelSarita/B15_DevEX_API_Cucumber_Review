Feature: User Profile Operations


  Scenario: Retrieve all profiles t01
    When The user sends a GET request and able to see all profiles
    Then The user verifies that the status code is 200


  Scenario: Retrieve all profiles t02
    When The user sends a GET request and able to see all profiles second way
    Then The user verifies that the status code is 200


  Scenario Outline: Get user profile with Path Param t03
    When The user sends a GET request with <id>
    Then The user verifies that the status code is 200
    And The user verifies that user's info name is "<name>" and company is "<company>" and location is "<location>" and email is "<email>"
    Examples:
      | id   | name           | company              | location         | email                         |
      | 2278 | Sarita         | Google               | germany          | sarita2020@gmail.com          |
      | 1543 | Jack Nicholson | Disney+              | Hollywood        | jack_nicholson@eurotech.study |
      | 681  | Ihsan          | EuroTech             | Turkey           | instructorihsan@eurotech.com  |
      | 730  | Jack Sparrow   | Hermiston - Kassulke | North Aubreeside | sparrow@eurotech.com          |