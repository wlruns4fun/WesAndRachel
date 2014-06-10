$LOAD_PATH.unshift(File.join(File.dirname(__FILE__), '../../', 'lib'))

require 'page-object'
require 'watir-webdriver'

$LOCAL = 'http://localhost:8080/WesAndRachel'
$PROD = 'http://wesandrachel.com'
$ENV = $LOCAL

Before do
  # use arg '--test-type' because chrome complains about '--ignore-certificate-errors' being set by default
  @browser = Watir::Browser.new :chrome, :switches => %w[--test-type]
end

After do
  @browser.close
end