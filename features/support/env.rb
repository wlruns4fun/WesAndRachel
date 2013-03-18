require 'page-object'
require 'watir-webdriver'

$LOCAL = 'http://localhost:8080/WesAndRachel'
$PROD = 'http://wesandrachel.cloudfoundry.com'
$ENV = $LOCAL

Before do
  @browser = Watir::Browser.new :chrome
end

After do
  @browser.close
end