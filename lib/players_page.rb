class PlayersPage
  include PageObject

    page_url $ENV + '/foosball/players'

    h1 :header, :id => 'header'
    text_field :search_filter, :class => 'ui-input-text'
    ul :players_list, :id => 'playersList'
    span :rank, :name => 'rank'
    span :first_name, :name => 'firstName'
    span :last_name, :name => 'lastName'
    span :total_wins, :name => 'totalWins'
    span :total_losses, :name => 'totalLosses'
    span :elo_rating, :name => 'eloRating'
end