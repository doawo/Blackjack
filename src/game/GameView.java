package game;

import deck.BlackjackCard;
import deck.Card;
import players.*;

public class GameView {

    public static boolean isAce(BlackjackCard card){
        if (card.get_faceValue() == 1)
            return true;
        else
            return false;
    }

    public static boolean playAction(Player player, Dealer dealer, int action) throws InterruptedException {

        BlackjackCard playerFC = player.getHands().get_currentHand().get(0);
        BlackjackCard playerSC = player.getHands().get_currentHand().get(1);

        switch (action) {
            default:
                return true;
            case 1:
                if (player.getHands().resolveScore() < 21) {
                    BlackjackCard newCard = Game.get_shoe().getSpecificDeck(Game.currentGame).getRandomCard(0);

                    if(isAce(newCard)){
                        if(player.getHands().resolveScore() + newCard.get_gameValue() > 21){
                            newCard.set_gameValue(1);
                        }
                    }

                    player.getHands().addCard(newCard);
                    String faceValue = Card.translateFaceCard(newCard);
                    System.out.println("Your card is " + faceValue + " of " + newCard.get_suit() + "S");

                    Game.currentMove++;

                    if(player.getHands().resolveScore() > 21) {
                        GameController.lost(player, dealer);
                        return true;
                    }
                }
                else
                    System.out.println("You already have enough cards!");
                break;
            case 2:
                if (playerFC.get_faceValue() == playerSC.get_faceValue() && Game.currentMove == 0) {
                    System.out.println("Player can split!");
                }else if (Game.currentMove > 0)
                    System.out.println("You missed your chance!");
                else
                    System.out.println("You can't split " + Card.translateFaceCard(playerFC) + " of " + playerFC.get_suit() + "S and " + Card.translateFaceCard(playerSC) + " of " + playerSC.get_suit() + "S!");
                break;
            case 3:
                return GameController.validateAction(player, dealer);
        }
        return false;
    }
}
