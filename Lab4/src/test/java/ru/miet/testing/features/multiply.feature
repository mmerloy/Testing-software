@calculator
Feature: Multiply

  @positive @sprint3
  Scenario Outline: Multiply two double numbers
    Given I have entered first number <arg1> into the calculator
    And I have entered second number <arg2> into the calculator
    When I press multiply
    Then the result should be <arg12> on the screen
    Examples:
      | arg1  | arg2 | arg12  |
      | 50.0  | 5.0  | 250.0  |
      | 6.0   | -3.0 | -18.0  |
      | -10.0 | -5.0 | 50.0   |
      | -30.0 | 10.0 | -300.0 |