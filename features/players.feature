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
    Then I see a list of all the Players


  Scenario: View Player information
  #============================================================================
    Given I go to the Players page
    When I see a list of all the Players
    Then the list contains each Player's rank
      And the list contains each Player's first name
      And the list contains each Player's last name
      And the list contains each Player's total wins
      And the list contains each Player's total losses
      And the list contains each Player's Elo rating
      And the list contains each Player's Categories


  Scenario: Search Players by name
  #============================================================================
    Given I go to the Players page
      And I see a list of all the Players
      And I see the Players search filter
      And I see "Rachel" in the Players search results
    When I enter "Wes" in the Players search filter
    Then I see "Wes" in the Players search results
      And I do not see "Rachel" in the Players search results


  Scenario: Search Players by Category
  #============================================================================
    Given I go to the Players page
      And I see a list of all the Players
      And I see the Players search filter
      And I see "Rachel Lewis" in the Players search results
    When I enter "Cardinal Solutions" in the Players search filter
    Then I see "Wes Lewis" in the Players search results
      And I do not see "Rachel Lewis" in the Players search results