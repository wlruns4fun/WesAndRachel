#==============================================================================
Feature: Player Rankings
#==============================================================================

  Scenario: View the Player Rankings page
  #============================================================================
    When I go to the Players page
    Then the page header says "Player Rankings"


  Scenario: View list of players
  #============================================================================
    When I go to the Players page
    Then I see a list of all the players


  Scenario: View Player information
  #============================================================================
    Given I go to the Players page
    When I see a list of all the players
    Then I see each player's rank
      And I see each player's first name
      And I see each player's last name
      And I see each player's total wins
      And I see each player's total losses
      And I see each player's Elo rating


  Scenario: Search Players
  #============================================================================
    Given I go to the Players page
      And I see a list of all the players
      And I see the search filter
      And I see "Rachel" in the search results
    When I enter "Wes" in the search filter
    Then I see "Wes" in the search results
      And I do not see "Rachel" in the search results