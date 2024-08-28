Feature: Register User
  @wip
  Scenario Outline: DevEx Register t04
    When The user sends a POST request with "<email>" and "<password>" and "<name>" and "<google>" and "<facebook>" and "<github>"
    Then The user verifies that the status code is <statusCode>
    And The user verifies that response body contains "token"
    And The compiler gets the token
    Examples:
      | email           | password | name | google       | facebook       | github       | statusCode |
      | sara5@gamil.com | test1234 | Sara | ProfLaGoogle | ProfLaFacebook | ProfLaGithub | 200        |


  Scenario Outline: User should be able to send POST request and get the token and save profile t05
    When The user sends a POST request with "<company>" and "<website>" and "<location>" and "<status>" and "<skills>" and "<githubusername>" and "<youtube>" and "<twitter>" and "<facebook>" and "<linkedin>" and "<instagram>"
    Then The user verifies that the status code is <statusCode>
    And The user verifies that name is "<name>" and email is "<email>"
    Examples:
      | company    | website            | location | status    | skills  | githubusername | youtube | twitter    | facebook       | linkedin     | instagram       | statusCode | name | email           |
      | BerlinBros | www.berlinbros.com | Madrid   | Professor | API, UI | ProfLaGithub   | ProfYou | ProfTitter | ProfLaFacebook | ProfLinkedin | ProfLaInstagram | 200        | Sara | sara5@gamil.com |