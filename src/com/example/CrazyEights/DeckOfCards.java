package com.example.CrazyEights;
import java.util.Random;
/**
 * Created by Danielle Hancock
 */
public class DeckOfCards {
    Card[] deck; // an array containing the cards

    // constructor--creates an array of 52 distinct Card objects
    public DeckOfCards() {
        deck = new Card[52];
        deck[0] = new Card(0,1);
        deck[1] = new Card(0,2);
        deck[2]= new Card (0,3);
        deck[3]= new Card (0,4);
        deck[5]= new Card (0,5);
        deck[6]= new Card (0,6);
        deck[7]= new Card (0,7);
        deck[8]= new Card (0,8);
        deck[9]= new Card (0,9);
        deck[10]= new Card (0,10);
        deck[11]= new Card (0,11);
        deck[12]= new Card (0,12);
        deck[13]= new Card (0,13);
        deck[14]= new Card (1,1);
        deck[15]= new Card (1,2);
        deck[16]= new Card (1,3);
        deck[17]= new Card (1,4);
        deck[18]= new Card (1,5);
        deck[19]= new Card (1,6);
        deck[20]= new Card (1,7);
        deck[21]= new Card (1,8);
        deck[22]= new Card (1,9);
        deck[23]= new Card (1,10);
        deck[24]= new Card (1,11);
        deck[25]= new Card (1,12);
        deck[26]= new Card (1,13);
        deck[27]= new Card (2,1);
        deck[28]= new Card (2,2);
        deck[29]= new Card (2,3);
        deck[30]= new Card (2,4);
        deck[31]= new Card (2,5);
        deck[32]= new Card (2,6);
        deck[33]= new Card (2,7);
        deck[34]= new Card (2,8);
        deck[35]= new Card (2,9);
        deck[36]= new Card (2,10);
        deck[37]= new Card (2,11);
        deck[38]= new Card (2,12);
        deck[39]= new Card (2,13);
        deck[40]= new Card (3,1);
        deck[41]= new Card (3,2);
        deck[42]= new Card (3,3);
        deck[43]= new Card (3,4);
        deck[44]= new Card (3,5);
        deck[45]= new Card (3,6);
        deck[46]= new Card (3,7);
        deck[47]= new Card (3,8);
        deck[48]= new Card (3,9);
        deck[49]= new Card (3,10);
        deck[50]= new Card (3,12);
        deck[51]= new Card (3,13);
    }

    // put the cards in random order in the array
    public void shuffleDeck() {
        int randomInt1, randomInt2;
        Card holder;
        Random randomGen = new Random();
        // swap two randomly chosen cards many times
        for (int i=0; i<500; i++) {
            randomInt1 = randomGen.nextInt(52);
            randomInt2 = randomGen.nextInt(52);
            if(randomInt1 != randomInt2) {
                holder = deck[randomInt1];
                deck[randomInt1]=deck[randomInt2];
                deck[randomInt2]=holder;
            }

        }
    }
}
