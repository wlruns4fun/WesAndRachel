require 'page-object'
require 'watir-webdriver'

$domain = 'http://localhost:8080/WesAndRachel'

Before do
  @browser = Watir::Browser.new :chrome
end

After do
  @browser.close
end