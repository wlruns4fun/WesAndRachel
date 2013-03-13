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
    Then I see a list of all the Games


  Scenario: View Game information
  #============================================================================
    Given I go to the Games page
    When I see a list of all the Games
    Then the list contains each Game's date
      And the list contains each Game's winners
      And the list contains each Game's losers
      And the list contains each Game's shutout status
      And the list contains each Game's Players' Categories


  Scenario: Search Games by date
  #============================================================================
    Given I go to the Games page
      And I see a list of all the Games
      And I see the Games search filter
      And I see "2006-08-19" in the Games search results
    When I enter "2006-09-01" in the Games search filter
    Then I see "2006-09-01" in the Games search results
      And I do not see "2006-08-19" in the Games search results


  Scenario: Search Games by Player
  #============================================================================
    Given I go to the Games page
      And I see a list of all the Games
      And I see the Games search filter
      And I see "Rachel Lewis" in the Games search results
    When I enter "Charlie Ciancio" in the Games search filter
    Then I see "Charlie Ciancio" in the Games search results
      And I do not see "Rachel Lewis" in the Games search results


  Scenario: Search Games by shutout
  #============================================================================
    Given I go to the Games page
      And I see a list of all the Games
      And I see the Games search filter
      And I see "2007-09-14" in the Games search results
    When I enter "Wall of Shame" in the Games search filter
    Then I see "Wall of Shame" in the Games search results
      And I do not see "2007-09-14" in the Games search results


  Scenario: Search Games by Category
  #============================================================================
    Given I go to the Games page
      And I see a list of all the Games
      And I see the Games search filter
      And I see "Rachel Lewis" in the Games search results
    When I enter "Cardinal Solutions" in the Games search filter
    Then I see "Wes Lewis" in the Games search results
      And I do not see "Rachel Lewis" in the Games search results