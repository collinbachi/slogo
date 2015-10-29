# Game Design: mjb81 dcb31 rkj6 #

## Classes ##

Our implementation will have a class for each type of card. There will be an inheritance heirarchy with different types of cards, including Rules, Keepers, etc.

There will be Player classes for each player, which will contain a Hand and PlayedCards, which are Lists of Card objects.

There will also be a set of ActiveRules and ActiveGoal and ActiveUnGoal. 

There will be a Deck containing all unplayed Cards, and a Discard pile with all discarded cards.

## Gameplay ##

Each iteration will be a turn taken by a specific player. The current rule cards will be checked for each turn to govern how the play is made (i.e. how many cards are drawn and played by the player). Once the rules are set, the player will get n random cards, decide which m cards to play, and each card will execute some do() method once played. For keepers, this will simply be adding to the PlayedCards list of the player who played it. For actions, the do() method will need to use API calls from multiple players.

After each turn, the game will need to check if any of the winning (Goal) or losing (Ungoals) have been met. If so, the game will end and declare some winner or no winner, respectively. 

Thank you.
