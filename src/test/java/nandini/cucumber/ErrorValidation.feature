@tag
Feature: Error validation

@Regression
Scenario Outline: Validating the error
    Given I landed on Ecommerce website
    Given Logged in with username <name> and password <password>
    Then  "Incorrect email or password." message is displayed

    Examples:
        | name                  | password    | 
        | nandini@example.com   | Passwe@ord1 | 