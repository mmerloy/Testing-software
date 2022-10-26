@calculator
Feature: Subtract

  @positive @sprint4
  Scenario Outline: Subtract two double numbers
    Given I have entered first number <arg1> into the calculator
    And I have entered second number <arg2> into the calculator
    When I press minus
    Then the result should be <arg12> on the screen
    Examples:
      | arg1  | arg2 | arg12 |
      | 50.0  | 5.0  | 45.0   |
      | 6.0   | -3.0 | 9.0   |
      | -10.0 | -5.0 | -5.0  |
      | -30.0 | 10.0 | -40.0 |