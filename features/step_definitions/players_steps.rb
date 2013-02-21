require_relative '../../lib/players_page'

When /^I go to the Players page$/ do
  @players_page = PlayersPage.new(@browser)
  @players_page.goto
end

When /^the page header says "([^"]*)"$/ do |text|
  @players_page.page_header_element.when_present do
    @players_page.page_header.should == text
  end
end