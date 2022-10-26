@calculator
Feature: Div

  @positive @sprint2
  Scenario Outline: Divide two numbers
    Given I have entered first number <arg1> into the calculator
    And I have entered second number <arg2> into the calculator
    When I press divide
    Then the result should be <arg12> on the screen
    Examples:
      | arg1 | arg2 | arg12              |
      | 50.0 | 70.0 | 0.7142857142857143 |
