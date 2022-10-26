@calculator
Feature: Summing

  @positive @sprint1
  Scenario Outline: Add two double numbers
    Given I have entered first number <arg1> into the calculator
    And I have entered second number <arg2> into the calculator
    When I press plus
    Then the result should be <arg12> on the screen
    Examples:
      | arg1  | arg2 | arg12 |
      | 50.0  | 5.0  | 55.0  |
      | 6.0   | -3.0 | 3.0   |
      | -10.0 | -5.0 | -15.0 |
      | -30.0 | 10.0 | -20.0 |