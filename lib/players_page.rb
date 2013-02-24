class PlayersPage
  include PageObject

    page_url $domain + '/foosball/players'

    h1 :page_header, :id => 'pageHeader'
    ordered_list :players_list, :id => 'playersList'
end