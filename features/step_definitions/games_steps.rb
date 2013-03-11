$LOAD_PATH.unshift(File.join(File.dirname(__FILE__), '../../', 'lib'))

require 'games_page'

When /^I go to the Games page$/ do
  @games_page = GamesPage.new(@browser)
  @games_page.goto
end

Then /^the Games page header says "([^"]*)"$/ do |text|
  pageHeader = @games_page.header
  fail('The page header says \''+pageHeader+'\' instead of \''+text+'\'') unless(pageHeader.eql? text)
end

Then /^I see a list of all the games$/ do
  @games_page.games_list_element.wait_until(180) do
    @games_page.games_list.length > 0
  end
end

Then /^the list contains each game's date$/ do
  fail('\'Date\' does not exist') unless(!@games_page.date.nil?)
end

Then /^the list contains each game's winners$/ do
  fail('\'Winner1\' does not exist') unless(!@games_page.winner1.nil?)
  fail('\'Winner2\' does not exist') unless(!@games_page.winner2.nil?)
end

Then /^the list contains each game's losers$/ do
  fail('\'Loser1\' does not exist') unless(!@games_page.loser1.nil?)
  fail('\'Loser2\' does not exist') unless(!@games_page.loser2.nil?)
end

Then /^the list contains each game's shutout status$/ do
  fail('\'Shutout\' does not exist') unless(!@games_page.shutout.nil?)
end