$LOAD_PATH.unshift(File.join(File.dirname(__FILE__), '../../', 'lib'))

require 'players_page'

When /^I go to the Players page$/ do
  @players_page = PlayersPage.new(@browser)
  @players_page.goto
end

Then /^the page header says "([^"]*)"$/ do |text|
  @players_page.page_header.should == text
end

Then /^I see a list of all the players$/ do
  @players_page.players_list_element.wait_until do
    @players_page.players_list_element.items > 0
  end
end