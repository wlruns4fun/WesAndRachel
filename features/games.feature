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
      And the list contains each Game's Players' common Categories


  Scenario: Search Games by date
  #============================================================================
    Given I go to the Games page
      And I see a list of all the Games
      And I see the Games search filter
      And I see "2013-11-19" in the Games search results
    When I enter "2013-11-18" in the Games search filter
    Then I see "2013-11-18" in the Games search results
      And I do not see "2013-11-19" in the Games search results


  Scenario: Search Games by Player
  #============================================================================
    Given I go to the Games page
      And I see a list of all the Games
      And I see the Games search filter
      And I see "Wes Lewis" in the Games search results
    When I enter "Mark Stratis" in the Games search filter
    Then I see "Mark Stratis" in the Games search results
      And I do not see "Wes Lewis" in the Games search results


  Scenario: Search Games by shutout
  #============================================================================
    Given I go to the Games page
      And I see a list of all the Games
      And I see the Games search filter
      And I see "2013-11-19" in the Games search results
    When I enter "wall of shame" in the Games search filter
    Then I see "WALL OF SHAME" in the Games search results
      And I do not see "2013-11-19" in the Games search results


  Scenario: Search Games by Category
  #============================================================================
    Given I go to the Games page
      And I see a list of all the Games
      And I see the Games search filter
      And I see "Mike Hire" in the Games search results
    When I enter "cardinal solutions" in the Games search filter
    Then I see "Wes Lewis" in the Games search results
      And I do not see "Mike Hire" in the Games search results