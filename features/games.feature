#==============================================================================
Feature: Game History
#==============================================================================


  Scenario: View the Game History page
  #============================================================================
    When I go to the Games page
    Then the Games page header says "Game History"


  Scenario: View list of Games
  #============================================================================
    When I go to the Games page
    Then I see a list of all the games


  @Test
  Scenario: View Game information
  #============================================================================
    Given I go to the Games page
    When I see a list of all the games
    Then the list contains each game's date
      And the list contains each game's winners
      And the list contains each game's losers