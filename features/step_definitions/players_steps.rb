$LOAD_PATH.unshift(File.join(File.dirname(__FILE__), '../../', 'lib'))

require 'players_page'

When /^I go to the Players page$/ do
  @players_page = PlayersPage.new(@browser)
  @players_page.goto
end

Then /^the page header says "([^"]*)"$/ do |text|
  @players_page.header.should == text
end

Then /^I see a list of all the players$/ do
  @players_page.players_list_element.wait_until do
    @players_page.players_list.length > 0
  end
end

Then /^I see each player's rank$/ do
  !@players_page.rank.nil?
end

Then /^I see each player's first name$/ do
  !@players_page.first_name.nil?
end

Then /^I see each player's last name$/ do
  !@players_page.last_name.nil?
end

Then /^I see each player's total wins$/ do
  !@players_page.total_wins.nil?
end

Then /^I see each player's total losses$/ do
  !@players_page.total_losses.nil?
end

Then /^I see each player's Elo rating$/ do
  !@players_page.elo_rating.nil?
end

Then /^I see the search filter$/ do
  !@players_page.search_filter_element.nil?
end

When /^I enter "([^"]*)" in the search filter$/ do |text|
  @players_page.search_filter = text
end

Then /^I see "([^"]*)" in the search results$/ do |text|
  @players_page.players_list.include? text
end

Then /^I do not see "([^"]*)" in the search results$/ do |text|
  !@players_page.players_list.include? text
end

