// Danielle Hancock
/* Rules of the game: You win when there are no cards left in your hand. You play a card in your hand by clicking on it.
To play a card, it must match either the number or the suit of the card on top of the stack. However, you can play an eight
at any time. When you play a card, it replaces the card on top of the stack. Click on the stack of unused cards (the image
of a card back) to draw a new card. If you run out of cards to draw and cannot play any of the cards in your hand,
or if your hand is full and you cannot play any of the cards in your hand, you lose.*/

package com.example.CrazyEights;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    // used to change the card images
    ImageView card1Image;
    ImageView card2Image;
    ImageView card3Image;
    ImageView card4Image;
    ImageView card5Image;
    ImageView card6Image;
    ImageView card7Image;
    ImageView card8Image;
    ImageView card9Image;
    ImageView card10Image;
    ImageView card11Image;
    ImageView card12Image;
    ImageView topCardImage;
    ImageView newCardImage;
    TextView numOfCardsOppText;
    TextView text1;
    TextView text2;

    Card[] myCards; // stores the cards in your hand
    Card[] oppCards; // stores your opponent's hand
    DeckOfCards myDeck; // stores the entire deck of cards
    Card topCard; // the card that is currently on top of the stack
    Card blankCard; // a blank Card object used to fill the empty spaces in your hand
    int index; // index of the next card in the stack of unused cards
    int numOfCards; // how many non-blank cards are in your hand
    int numOfCardsOpp; // how many non-blank cards are in your opponent's hand

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // get the id for each of the card button images
        card1Image = (ImageView) findViewById(R.id.card1);
        card2Image = (ImageView) findViewById(R.id.card2);
        card3Image = (ImageView) findViewById(R.id.card3);
        card4Image = (ImageView) findViewById(R.id.card4);
        card5Image = (ImageView) findViewById(R.id.card5);
        card6Image = (ImageView) findViewById(R.id.card6);
        card7Image = (ImageView) findViewById(R.id.card7);
        card8Image = (ImageView) findViewById(R.id.card8);
        card9Image = (ImageView) findViewById(R.id.card9);
        card10Image = (ImageView) findViewById(R.id.card10);
        card11Image = (ImageView) findViewById(R.id.card11);
        card12Image = (ImageView) findViewById(R.id.card12);
        topCardImage = (ImageView) findViewById(R.id.topOfDeck);
        newCardImage = (ImageView) findViewById(R.id.newCardButton);
        numOfCardsOppText = (TextView) findViewById(R.id.oppNumCards);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        //create the deck of cards
        myDeck = new DeckOfCards();
        myDeck.shuffleDeck();

        numOfCards=0;
        numOfCardsOpp = 0;

        // put the first 5 cards from the deck in my hand
        myCards = new Card[12];
        for (index=0; index<5; index++) {
            myCards[index] = myDeck.deck[index];
            numOfCards++;
        }

        // put the next 5 cards from the deck in your opponent's hand
        oppCards = new Card[12];
        for (int i=0; i<5; i++) {
            oppCards[i] = myDeck.deck[index];
            numOfCardsOpp++;
            index++;
        }

        // fill the rest of my hand with blank cards
        blankCard = new Card(0,0);
        for(int i=5; i<12; i++) {
            myCards[i] = blankCard;
            oppCards[i] = blankCard;
        }


        // put the next card from the deck on top of the stack
        topCard = myDeck.deck[index];
        index++;

        // update the images
        updateHand();

    }

    // updates the displayed images to match the cards in your hand and the top card
    public void updateHand() {
        card1Image.setImageResource(myCards[0].id);
        card2Image.setImageResource(myCards[1].id);
        card3Image.setImageResource(myCards[2].id);
        card4Image.setImageResource(myCards[3].id);
        card5Image.setImageResource(myCards[4].id);
        card6Image.setImageResource(myCards[5].id);
        card7Image.setImageResource(myCards[6].id);
        card8Image.setImageResource(myCards[7].id);
        card9Image.setImageResource(myCards[8].id);
        card10Image.setImageResource(myCards[9].id);
        card11Image.setImageResource(myCards[10].id);
        card12Image.setImageResource(myCards[11].id);
        topCardImage.setImageResource(topCard.id);
    }

    // tests if a card can be played
    public boolean isValidMove(Card topCard, Card playedCard) {
        if (playedCard.num==0 && playedCard.suit==0) return false;
        if (playedCard.num==8) return true; //card is an 8
        if (playedCard.num==topCard.num) return true; // numbers are the same
        if (playedCard.suit==topCard.suit) return true; // suits are the same
        return false; // not a valid move
    }

    // is called when the player clicks on the stack of unused cards (the image of a card back)
    // draws a card from the deck and puts in it the player's hand
    public void drawNewCard(View v) {
            if (!haveYouWon() & !hasOppWon()) { // if you've won or lost, stop drawing new cards
                if (checkIndex()) { // if there are still cards left in the deck
                    // check each card in your hand to see if it's empty; put new card in the first empty slot
                    for (int i = 0; i < 12; i++) {
                        if (myCards[i] == blankCard) {
                            myCards[i] = myDeck.deck[index];
                            index++;
                            numOfCards++;
                            updateHand();
                            return;
                        }
                    }
                    //no empty slots left, can't draw new card
                    if (!haveValidMove())
                        playOpponent();
                }

            }
    }

    // called when the player clicks on a card in his/her hand
    public void playCard(View v) {
        if (!hasOppWon() && !haveYouWon()) {
            int x = Integer.parseInt(v.getTag().toString()); // which card was clicked on
            if (isValidMove(topCard, myCards[x])) { // check if the move is allowed
                topCard = myCards[x]; // put the played card on top of the stack
                myCards[x] = blankCard; // make the place where the played card was empty
                numOfCards--;
                updateHand();
                if (!haveYouWon()) { // check if you've won the game yet
                    playOpponent();
                }
            }
        }
    }

    //returns true if the stack of unused cards is not empty
    //if it is empty, returns false and replaces image of card back with image of a blank white card
    public boolean checkIndex() {
        if (index>51) {
            newCardImage.setImageResource(R.drawable.blank);
            return false;
        }
        return true;
    }

    // returns true if you've won the game (if you have no cards left in your hand)
    public boolean haveYouWon() {
        if(numOfCards==0) {
            text1.setText("You won!");
            text2.setText("");
            numOfCardsOppText.setText("");
            return true;
        }
        else return false;
    }

    public boolean hasOppWon(){
        if(numOfCardsOpp==0) {
            text1.setText("You lost.");
            text2.setText("");
            numOfCardsOppText.setText("");
            return true;
        }
        else return false;
    }


    // start over by calling a new instance of MyActivity when the "New Game" button is clicked
    public void newGame(View v) {
        Intent myIntent = new Intent(MyActivity.this, MyActivity.class);
        startActivity(myIntent);
        finish();
    }

    // your opponent takes a turn
    public void playOpponent () {
        // check each card in the opponent's hand to see if it can be played
        for(int i=0; i<12; i++) {
            if(isValidMove(topCard,oppCards[i])) {
                topCard = oppCards[i];
                oppCards[i] = blankCard;
                numOfCardsOpp--;
                numOfCardsOppText.setText(""+numOfCardsOpp);
                topCardImage.setImageResource(topCard.id);
                hasOppWon();
                return;
            }
        }
        // no valid moves; opponent draws a new card
        if (numOfCardsOpp <12) {
            drawNewCardOpponent();
            playOpponent();
            return;
        }
        if (numOfCardsOpp==12) {
            playOpponent();
        }

    }

    public void drawNewCardOpponent () {
        if (checkIndex()) { // if there are still cards left in the deck
            // check each card in opponent's hand to see if it's empty; put new card in the first empty slot
            for (int i=0; i < 12; i++) {
                if (oppCards[i] == blankCard) {
                    oppCards[i] = myDeck.deck[index];
                    index++;
                    numOfCardsOpp++;
                    numOfCardsOppText.setText(""+numOfCardsOpp);
                    return;
                }
            }
            //no empty slots left, can't draw new card
        }
    }

    // returns true if you have at least one card that can be played in your hand
    public boolean haveValidMove() {
        for(int i=0; i<12; i++) {
            if(isValidMove(topCard, myCards[i])) return true;
        }
        return false;
    }

}


