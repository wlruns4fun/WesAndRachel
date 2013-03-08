$LOAD_PATH.unshift(File.join(File.dirname(__FILE__), '../../', 'lib'))

require 'players_page'

When /^I go to the Players page$/ do
  @players_page = PlayersPage.new(@browser)
  @players_page.goto
end

Then /^the page header says "([^"]*)"$/ do |text|
  pageHeader = @players_page.header
  fail('The page header says \''+pageHeader+'\' instead of \''+text+'\'') unless(pageHeader.eql? text)
end

Then /^I see a list of all the players$/ do
  @players_page.players_list_element.wait_until do
    @players_page.players_list.length > 0
  end
end

Then /^the list contains each player's rank$/ do
  fail('\'Rank\' does not exist') unless(!@players_page.rank.nil?)
end

Then /^the list contains each player's first name$/ do
  fail('\'First Name\' does not exist') unless(!@players_page.first_name.nil?)
end

Then /^the list contains each player's last name$/ do
  fail('\'Last Name\' does not exist') unless(!@players_page.last_name.nil?)
end

Then /^the list contains each player's total wins$/ do
  fail('\'Total Wins\' does not exist') unless(!@players_page.total_wins.nil?)
end

Then /^the list contains each player's total losses$/ do
  fail('\'Total Losses\' does not exist') unless(!@players_page.total_losses.nil?)
end

Then /^the list contains each player's Elo rating$/ do
  fail('\'Elo Rating\' does not exist') unless(!@players_page.elo_rating.nil?)
end

Then /^the list contains each player's categories$/ do
  fail('\'Categories\' do not exist') unless(!@players_page.categories.nil?)
end

Then /^I see the search filter$/ do
  fail('The search filter does not exist') unless(!@players_page.search_filter_element.nil?)
end

When /^I enter "([^"]*)" in the search filter$/ do |text|
  @players_page.search_filter = text
end

Then /^I see "([^"]*)" in the search results$/ do |text|
  fail('The search results do not contain \''+text+'\'') unless(@players_page.players_list.include? text)
end

Then /^I do not see "([^"]*)" in the search results$/ do |text|
  fail('The search results should not contain \''+text+'\'') unless (!@players_page.players_list.include? text)
end

