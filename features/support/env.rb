$LOAD_PATH.unshift(File.join(File.dirname(__FILE__), '../../', 'lib'))

require 'page-object'
require 'watir-webdriver'

$domain = 'http://wesandrachel.cloudfoundry.com'

Before do
  @browser = Watir::Browser.new(:chrome)
end

After do
  @browser.close
end