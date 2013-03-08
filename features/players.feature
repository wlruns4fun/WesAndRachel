#==============================================================================
Feature: Player Rankings
#==============================================================================


  Scenario: View the Player Rankings page
  #============================================================================
    When I go to the Players page
    Then the Players page header says "Player Rankings"


  Scenario: View list of Players
  #============================================================================
    When I go to the Players page
    Then I see a list of all the players


  Scenario: View Player information
  #============================================================================
    Given I go to the Players page
    When I see a list of all the players
    Then the list contains each player's rank
      And the list contains each player's first name
      And the list contains each player's last name
      And the list contains each player's total wins
      And the list contains each player's total losses
      And the list contains each player's Elo rating
      And the list contains each player's categories


  Scenario: Search Players by name
  #============================================================================
    Given I go to the Players page
      And I see a list of all the players
      And I see the Players search filter
      And I see "Rachel" in the search results
    When I enter "Wes" in the search filter
    Then I see "Wes" in the search results
      And I do not see "Rachel" in the search results


  Scenario: Search Players by category
  #============================================================================
    Given I go to the Players page
      And I see a list of all the players
      And I see the Players search filter
      And I see "Rachel Lewis" in the search results
    When I enter "Cardinal Solutions" in the search filter
    Then I see "Wes Lewis" in the search results
      And I do not see "Rachel Lewis" in the search results