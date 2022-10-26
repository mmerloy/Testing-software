@calculator
Feature: Sum

  @positive @sprint1
  Scenario: Add two numbers
    Given I have entered first number 50.0 into the calculator
    And I have entered second number 70.0 into the calculator
    When I press plus
    Then the result should be 120.0 on the screen
