package game;

import players.*;

import java.util.concurrent.TimeUnit;

public class GameController {

    public static void win(Player player, Dealer dealer){
        System.out.println("You've won! Congratulations!");
        System.out.println("You've won with total score of " + player.getHands().resolveScore());
        System.out.println("Dealer's score: " + dealer.getHands().resolveScore());
        player.set_totalCash(player.get_totalCash() + player.get_bet());
        System.out.println("Your winning: " + player.get_bet() * 2);
    }

    public static void lost(Player player, Dealer dealer){
        System.out.println("You've lost with total score of " + player.getHands().resolveScore());
        System.out.println("Dealer's score: " + dealer.getHands().resolveScore());
        player.set_totalCash(player.get_totalCash() - player.get_bet());
        System.out.println("Your lost: " + player.get_bet());
    }

    public static void tie(Player player, Dealer dealer){
        System.out.println("A tie! Your score: " + player.getHands().resolveScore());
        System.out.println("Dealer's score: " + dealer.getHands().resolveScore());
    }

    public static boolean validateAction(Player player, Dealer dealer) throws InterruptedException {
        if (player.getHands().resolveScore() > 21) {
            lost(player, dealer);
            return true;
        }

        dealerTurns(player, dealer);

        if (player.getHands().resolveScore() == dealer.getHands().resolveScore()){
            tie(player, dealer);
            return true;
        }

        if (player.getHands().resolveScore() == 21) {
            win(player, dealer);
            return true;
        }

        if (player.getHands().resolveScore() < dealer.getHands().resolveScore() && dealer.getHands().resolveScore() <= 21){
            lost(player, dealer);
        }else{
            win(player, dealer);
        }
        return true;
    }

    public static void dealerTurns(Player player, Dealer dealer) throws InterruptedException {
        if (dealer.getHands().resolveScore() <= 16){
            Game.hit(dealer);
            System.out.println("Dealer takes new card!");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("\nDealer's cards: " + dealer.getHands().getScores());
            dealerTurns(player, dealer);
        }
    }
}

