package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String card1 = ("");
        String card2 = ("");
        String again = ("y");
        String newCardStr = ("");
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("how much money do you have");
        int bank = input.nextInt();
        int startBank = bank;
        while (!again.contains("n")) {
            System.out.println("how much money do you want to bet ");
            int betAmount = input.nextInt();
            String valid = ("n");
            while(valid.contains("n")) {
                if (betAmount > bank) {
                    System.out.println("that is too much enter a value below " + bank);
                }else{
                    valid = ("y");
                }
            }
            int compCard1 = (random.nextInt(11) + 1);
            int compCard2 = (random.nextInt(11) + 1);
            int compTotal = compCard1 + compCard2;

            int userCard1 = (random.nextInt(11) + 1);
            int userCard2 = (random.nextInt(11) + 1);
            int userTotal = userCard1 + userCard2;
            if (userCard1 == 1){
                card1 = ("ace");
            }
            else if (userCard1 == 11){
                card1 = ("jack");
            }else {
                card1 = String.valueOf(userCard1);
            }
            if (userCard2 == 1){
                card2 = ("ace");
            }
            else if (userCard2 == 11){
                card2 = ("jack");
            }else {
                card2 = String.valueOf(userCard2);
            }


            System.out.println("your cards are " + card2 + " and " + card1 + " so your total is " + userTotal);

            if (userTotal <= 21) {
                if (compTotal > 21) {
                    System.out.println("the computer is over 21 you win");
                    bank = bank + betAmount;
                    System.out.println("you have "+bank+" in you bank");
                } else {
                    System.out.println("do you want another card:y/n");
                    String anotherCard = input.next();
                    while (userTotal <= 21) {
                        if (anotherCard.contains("y")) {
                            int newCard = (random.nextInt(11) + 1);
                            userTotal = userTotal + newCard;
                            if (newCard == 1){
                                newCardStr = ("ace");
                            }
                            else if (newCard == 11){
                                newCardStr = ("jack");
                            }else {
                                newCardStr = String.valueOf(newCard);
                            }
                            System.out.println("your new card is " +newCardStr+ " so your total is " + userTotal);
                            if (userTotal > 21) {
                                System.out.println("your total is over 21 you have lost");
                            } else {
                                System.out.println("do you want another card:y/n");
                                anotherCard = input.next();
                            }
                        } else {
                            String compAgain = ("y");
                            while (compAgain.contains("y")) {
                                if (compTotal < 15) {
                                    int compNewCard = (random.nextInt(11) + 1);
                                    compTotal = compTotal + compNewCard;
                                    if (compTotal > 21) {
                                        compAgain = ("n");
                                        System.out.println("the computer's total is " + compTotal + ", over 21 so you win");
                                    }
                                } else {
                                    compAgain = ("n");
                                }

                            }
                            if (userTotal>compTotal){
                                System.out.println("well done you win with "+userTotal+" and the computer had "+compTotal);
                                bank = bank +betAmount;
                                System.out.println("you have "+bank+" in you bank");
                                break;
                            }
                            else if (userTotal == compTotal){
                                System.out.println("it was a draw you both got "+userTotal);
                                System.out.println("you have "+bank+" in you bank");
                                break;
                            }
                            else if (compTotal > 21){
                                break;
                            }
                            else{
                                System.out.println("the computer was higher than you at "+compTotal+" so you lose");
                                bank = bank - betAmount;
                                System.out.println("you have "+bank+" in you bank");
                                break;
                            }

                        }
                    }
                }
                System.out.println("do you want to play again:y/n");
                again = input.next();
            }
        }
        int bankDiff = bank - startBank;
        if (bankDiff >= 0) {
            System.out.println("you started with " + startBank + " and you are now on " + bank + " you have gained "+bankDiff);
        }else{
            System.out.println("you started with " + startBank + " and you are now on " + bank + " you have lose "+bankDiff*-1);
        }
    }
}

