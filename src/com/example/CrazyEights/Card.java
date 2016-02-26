package com.example.CrazyEights;

/**
 * Created by Danielle Hancock
 */
public class Card {
    public int suit; // 0=hearts, 1=diamonds, 2=clubs, 3=spades
    public int num; // 1=ace, 11=jack, 12=queen, 13=king
    public int id; // id of the drawable resource; used in the function setImageResource to draw the card

    //constructor--create a new Card object with the given suit and number
    public Card (int x, int y) {
        suit = x;
        num = y;
        // set the card id, based on the suit and number
        if (suit == 0 ) { //hearts
            if (num==0) id=R.drawable.blank; // a blank white card
            else if(num==1) id=R.drawable.acehearts;
            else if(num==2) id=R.drawable.twohearts;
            else if(num==3) id=R.drawable.threehearts;
            else if(num==4) id=R.drawable.fourhearts;
            else if(num==5) id=R.drawable.fivehearts;
            else if (num==6) id=R.drawable.sixhearts;
            else if (num==7) id=R.drawable.sevenhearts;
            else if (num==8) id=R.drawable.eighthearts;
            else if(num==9) id=R.drawable.ninehearts;
            else if (num==10) id=R.drawable.tenhearts;
            else if (num==11) id=R.drawable.jackhearts;
            else if (num==12) id=R.drawable.queenhearts;
            else if (num==13) id=R.drawable.kinghearts;
        }
        else if (suit == 1 ) { //diamonds
            if(num==1) id=R.drawable.acediamonds;
            else if(num==2) id=R.drawable.twodiamonds;
            else if(num==3) id=R.drawable.threediamonds;
            else if(num==4) id=R.drawable.fourdiamonds;
            else if(num==5) id=R.drawable.fivediamonds;
            else if (num==6) id=R.drawable.sixdiamonds;
            else if (num==7) id=R.drawable.sevendiamonds;
            else if (num==8) id=R.drawable.eightdiamonds;
            else if(num==9) id=R.drawable.ninediamonds;
            else if (num==10) id=R.drawable.tendiamonds;
            else if (num==11) id=R.drawable.jackdiamonds;
            else if (num==12) id=R.drawable.queendiamonds;
            else if (num==13) id=R.drawable.kingdiamonds;
        }
        else if (suit == 2 ) { //clubs
            if(num==1) id=R.drawable.aceclubs;
            else if(num==2) id=R.drawable.twoclubs;
            else if(num==3) id=R.drawable.threeclubs;
            else if(num==4) id=R.drawable.fourclubs;
            else if(num==5) id=R.drawable.fiveclubs;
            else if (num==6) id=R.drawable.sixclubs;
            else if (num==7) id=R.drawable.sevenclubs;
            else if (num==8) id=R.drawable.eightclubs;
            else if(num==9) id=R.drawable.nineclubs;
            else if (num==10) id=R.drawable.tenclubs;
            else if (num==11) id=R.drawable.jackclubs;
            else if (num==12) id=R.drawable.queenclubs;
            else if (num==13) id=R.drawable.kingclubs;
        }
        else if (suit == 3 ) { //spades
            if(num==1) id=R.drawable.acespades;
            else if(num==2) id=R.drawable.twospades;
            else if(num==3) id=R.drawable.threespades;
            else if(num==4) id=R.drawable.fourspades;
            else if(num==5) id=R.drawable.fivespades;
            else if (num==6) id=R.drawable.sixspades;
            else if (num==7) id=R.drawable.sevenspades;
            else if (num==8) id=R.drawable.eightspades;
            else if(num==9) id=R.drawable.ninespades;
            else if (num==10) id=R.drawable.tenspades;
            else if (num==11) id=R.drawable.jackspades;
            else if (num==12) id=R.drawable.queenspades;
            else if (num==13) id=R.drawable.kingspades;
        }
    }

}
