@calculator
Feature: Sub

  @positive @sprint4
  Scenario: Subtract two numbers
    Given I have entered first number 50.0 into the calculator
    And I have entered second number 70.0 into the calculator
    When I press minus
    Then the result should be -20.0 on the screen
