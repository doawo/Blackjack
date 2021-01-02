package game;

import deck.Shoe;
import players.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private static Shoe _shoe;
    private List<Player> _players = new ArrayList<Player>();
    private List<Dealer> _dealers = new ArrayList<Dealer>();

    public static int currentMove;
    public static int currentGame = -1;

    public Game() {
    }

    public Game(Shoe _shoe) {
        this._shoe = _shoe;
    }

    public static void info(Player player, Dealer dealer){
        System.out.println("Your current card values: " + player.getHands().getScores());
        System.out.println("Your total score: " + player.getHands().resolveScore());
        System.out.println("\nDealer's cards: " + dealer.getHands().getFirstCard().get_gameValue() + ", X");
    }

    public static void menu(){
        System.out.println("Please, select an action:");
        System.out.println("1. Hit");
        System.out.println("2. Split");
        System.out.println("3. Stand");
        System.out.println("4. Exit\n");
    }

    public static void bet(Player player, Scanner sc){
        System.out.println("Your total balance: " + player.get_totalCash());
        System.out.print("How much will you bet?: ");
        int bet = sc.nextInt();

        if(bet > player.get_totalCash() || bet <= 0){
            System.out.println("You can't make such bet!");
            bet(player, sc);
        }else
            player.set_bet(bet);
    }

    public void start(Player player, Dealer dealer) throws InterruptedException {

        currentMove = 0;
        currentGame++;

        player.getHands().removeHand();
        dealer.getHands().removeHand();

        if(currentGame >= _shoe.get_numberOfDecks()){
            System.out.println("Shoe is out of decks! Come again next time!");
            return;
        }

        Scanner sc = new Scanner(System.in);

        boolean isDone = false;

        bet(player, sc);

        hit(player);
        hit(player);

        hit(dealer);
        hit(dealer);

        while(!isDone) {

            if(currentMove == 0 && dealer.getHands().get_currentHand().get(0).get_gameValue() == 11){
                info(player, dealer);
                System.out.println("Dealer has Ace! Do you want to make insurance bet?");

                System.out.println("1. Make Insurance Bet");
                System.out.println("2. Add to bet");
                System.out.println("3. Continue");

                int insAction = sc.nextInt();

                switch (insAction){
                    case 1:
                        if(dealer.getHands().get_currentHand().get(1).get_gameValue() == 10){
                            System.out.println("Dealer checks for blackjack...");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println("Dealer has blackjack!");
                            player.set_bet(player.get_bet() * 2);
                            GameController.win(player, dealer);
                            isDone = true;
                            continue;
                        }else{
                            System.out.println("Dealer checks for blackjack...");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println("Dealer doesn't have blackjack!");
                            player.set_totalCash(player.get_totalCash() - player.get_bet());
                        }
                        break;
                    case 2:
                        System.out.println("How much do you want to add? (Keep in mind you can't take more cards)");
                        int addBet = sc.nextInt();
                        player.set_bet(player.get_bet() + addBet);
                        GameController.validateAction(player, dealer);
                        isDone = true;
                        continue;
                    default:
                        break;
                }
            }

            info(player, dealer);
            menu();

            int action = sc.nextInt();
            if(GameView.playAction(player, dealer, action)) {
                isDone = true;
                continue;
            }
        }
    }

    public static void hit(Player player) {
        player.getHands().addCard(_shoe.getSpecificDeck(currentGame).getRandomCard(0));
    }

    public static void hit(Dealer dealer) {
        dealer.getHands().addCard(_shoe.getSpecificDeck(currentGame).getRandomCard(0));
    }

    public void addPlayer(Player player){
        this._players.add(player);
    }

    public void addDealer(Dealer dealer){
        this._dealers.add(dealer);
    }

    public void removePlayer(Player player){
        this._players.remove(player);
    }

    public void removeDealer(Dealer dealer){
        this._dealers.remove(dealer);
    }

    public static Shoe get_shoe() {
        return _shoe;
    }

    public void set_shoe(Shoe _shoe) {
        this._shoe = _shoe;
    }

    public List<Player> get_players() {
        return _players;
    }

    public void set_players(List<Player> _players) {
        this._players = _players;
    }

    public List<Dealer> get_dealers() {
        return _dealers;
    }

    public void set_dealers(List<Dealer> _dealers) {
        this._dealers = _dealers;
    }
}
