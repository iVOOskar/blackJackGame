package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String again = ("y");
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        while (!again.contains("n")) {
            int compCard1 = (random.nextInt(11) + 1);
            int compCard2 = (random.nextInt(11) + 1);
            int compTotal = compCard1 + compCard2;

            int userCard1 = (random.nextInt(11) + 1);
            int userCard2 = (random.nextInt(11) + 1);
            int userTotal = userCard1 + userCard2;
            System.out.println("your numbers are " + userCard2 + " and " + userCard1 + " so your total is " + userTotal);

            if (userTotal <= 21) {
                if (compTotal > 21) {
                    System.out.println("the computer is over 21 you win");
                } else {
                    System.out.println("do you want another card:y/n");
                    String anotherCard = input.next();
                    while (userTotal <= 21) {
                        if (anotherCard.contains("y")) {
                            int newCard = (random.nextInt(11) + 1);
                            userTotal = userTotal + newCard;
                            System.out.println("your new card is " + newCard + " so your total is " + userTotal);
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
                                userTotal = 50;
                            }
                            else if (userTotal == compTotal){
                                System.out.println("it was a draw you both got "+userTotal);
                                userTotal = 50;
                            }
                            else if (compTotal > 21){
                                userTotal = 50;
                            }
                            else{
                                System.out.println("the computer was higher than you at "+compTotal+" so you lose");
                                userTotal = 50;
                            }

                        }
                    }
                }
                System.out.println("do you want to play again:y/n");
                again = input.next();
            }
        }
    }
}

