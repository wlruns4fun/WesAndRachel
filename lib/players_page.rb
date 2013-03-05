class PlayersPage
  include PageObject

    page_url $ENV + '/foosball/players'

    h1 :header, :id => 'header'
    ordered_list :players_list, :id => 'playersList'
end