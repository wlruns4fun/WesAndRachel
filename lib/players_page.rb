class PlayersPage
  include PageObject

    page_url($domain + '/foosball/players')

    h1(:page_header, :id => 'pageHeader')

end