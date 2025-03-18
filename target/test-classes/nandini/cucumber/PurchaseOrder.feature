
@tag 
Feature: Purchase the order from Ecommerce website
    

Background: 
Given I landed on Ecommerce website

 @tag2
 Scenario Outline: Positive test for submitting the order
    Given Logged in with username <name> and password <password>
    When  I add the product <productName> to cart
    And   Checkout <productName> and submit the order
    Then  "THANKYOU FOR THE ORDER." is displayed on ConfirmationPage

    Examples:
        | name                  | password   | productName  |
        | nandini@example.com  | Passw@ord1 | ZARA COAT 3  |