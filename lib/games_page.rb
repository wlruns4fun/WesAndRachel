class GamesPage
  include PageObject

    page_url $ENV + '/foosball/games'

    h1 :header, :id => 'header'
    text_field :search_filter, :class => 'ui-input-text'
    ul :games_list, :id => 'gamesList'
    span :date, :name => 'date'
    span :winner1, :name => 'winner1'
    span :winner2, :name => 'winner2'
    span :loser1, :name => 'loser1'
    span :loser2, :name => 'loser2'
    span :shutout, :name => 'shutout'
end