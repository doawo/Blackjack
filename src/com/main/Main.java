package com.main;

import datatypes.*;
//import dealer.*;
import datatypes.Person;
import deck.*;
import enums.*;
import game.*;
//import player.*;
import game.*;
import players.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Shoe shoe = new Shoe(8);
        shoe.createShoe();

        Game game = new Game(shoe);

        Hand plhand = new Hand();
        Hand dehand = new Hand();

        Address address = new Address("Baker st.", "London", "", "0203041", "UK");

        Person plperson = new Person("Bryce Carlson", "brycecarlson@gmail.com", "+2222093", address);
        Person deperson = new Person("Eve Era", "eveera@gmail.com", "+111230120", address);

        Player player = new Player("0001", "qwerty12345", 2000, AccountStatus.ACTIVE, plperson, plhand, 20, 2000);
        game.addPlayer(player);

        Dealer dealer = new Dealer("0001", "qwerty0988", 2000, AccountStatus.ACTIVE, deperson, dehand);
        game.addDealer(dealer);

        Scanner sc = new Scanner(System.in);

        boolean isDone = false;

        while(!isDone) {

            if (player.get_totalCash() == 0){
                if(player.get_balance() > 0){
                    System.out.println("You're out of cash, but you still have your bank account. Want to transfer money from your bank?");
                    System.out.println("Bank account status: " + player.get_balance());
                    System.out.println("1. Yes");
                    System.out.println("2. No");

                    int mfAction = sc.nextInt();

                    switch(mfAction){
                        case 1:
                            System.out.println("How much?");
                            int amount = sc.nextInt();
                            if(amount > player.get_balance()){
                                System.out.println("Wrong amount!");
                                isDone = true;
                            }else{
                                player.set_totalCash(amount);
                                player.set_balance(player.get_balance() - amount);
                            }
                            break;
                        default:
                            isDone = true;
                            break;
                    }
                }else if(player.get_balance() == 0){
                    System.out.println("You're out of money on both bank and cash!");
                    System.out.println("Better luck next time!");
                    isDone = true;
                    continue;
                }
            }

            System.out.println("Want to play?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int action = sc.nextInt();

            switch (action) {
                case 1:
                    game.start(player, dealer);
                    break;
                default:
                    isDone = true;
                    break;
            }
        }

    }
}
