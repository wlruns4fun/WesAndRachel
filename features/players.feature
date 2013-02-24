#===============================================================================
Feature: Player Rankings
#===============================================================================

  Scenario: View the Player Rankings page
    When I go to the Players page
    Then the page header says "Player Rankings"


  Scenario: View list of players
    When I go to the Players page
    Then I see a list of all the players


#  Scenario: Display alert if fail to load Players
#  Scenario: View Player information
#  Scenario: Search Players
#  Scenario: Players sorted by Elo