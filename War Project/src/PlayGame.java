import processing.core.*;

import java.util.ArrayList;

public class PlayGame extends PApplet {
    int buttonX, buttonY, buttonW, buttonH;
    int player1WinCount = 0;
    int player2WinCount = 0;
    Cards player1TieBreakerCard;
    Cards player2TieBreakerCard;

    WarGame warGame;
    ArrayList<Cards> player1Deck;
    ArrayList<Cards> player2Deck;

    public static void main(String[] args) {
        PApplet.main(PlayGame.class);


    }

    public void settings() {
        size(900, 900);
    }

    public void setup() {
        background(255);
        warGame = new WarGame(); // make a new warGame
        //makes all the new decks needed and shuffles
        ArrayList<Cards> deck = new ArrayList<Cards>();
        ArrayList<Cards> result = new ArrayList<Cards>(warGame.createDeck(deck));
        ArrayList<Cards> shuffled = new ArrayList<Cards>(warGame.shuffleDeck(result));
        player1Deck = new ArrayList<Cards>(warGame.p1Deck(shuffled));
        player2Deck = new ArrayList<Cards>(warGame.p2Deck(shuffled));
        buttonW = 100;
        buttonH = 40;
        buttonX = width / 2 - buttonW / 2;
        buttonY = height / 2 - buttonH / 2;


    }

    public void draw() {

        if (mouseX >= buttonX && mouseX <= buttonX + buttonW && mouseY >= buttonY && mouseY <= buttonY + buttonH ) {
            fill(255, 180, 30);
            textSize(10);


        } else {
            fill(100, 50, 80);
            textSize(20);

        }
        rect(buttonX, buttonY, buttonW, buttonH, 5);


        fill(255);
        textAlign(CENTER, CENTER);
        textSize(8);


        fill(0);
        textSize(20);
//        text(mouseX + "," + mouseY, mouseX + 10, mouseY + 10);
        text("Let's Play War", 440, 155);
        text("Player1 Win Count:" + player1WinCount, 260, 400);
        text("Player2 Win Count:" + player2WinCount, 620, 400);
        text("Player 1 Deck Size:" + player1Deck.size(), 100, 10);
        text("Player 2 Deck Size:" + player2Deck.size(), 100, 50);



    }

    public void mousePressed() {
        // Check if mouse is pressed within the bounds of the rectangle
        if (mouseX >= buttonX && mouseX <= buttonX + buttonW && mouseY >= buttonY && mouseY <= buttonY + buttonH ) {
            fill(255, 180, 30);
            textSize(10);
            background(255);
            if (player1Deck.isEmpty()) {
                textSize(30);
                text("Player 2 Wins the Game!", width / 2, height / 2);
                return; // ends the game
            } else if (player2Deck.isEmpty()) {
                textSize(30);
                text("Player 1 Wins the Game!", width / 2, height / 2);
                return;
            }
        if(player1Deck.size() >= 5 && player2Deck.size() >= 5){
            player1TieBreakerCard = player1Deck.get(4);
            player2TieBreakerCard = player2Deck.get(4);
        }



            // Check if both decks have at least one card
            if (player1Deck.size() > 0 && player2Deck.size() > 0) {
                Cards player1Card = player1Deck.get(0);
                Cards player2Card = player2Deck.get(0);

                player1Card.draw(this, 200);
                player2Card.draw(this, 550);
                delay(100);
                int warResult = warGame.war(player2Deck, player1Deck, 0);
                if (warResult == 2) {
                    player1WinCount++;
                } else if (warResult == 1) {
                    player2WinCount++;
                } else if (warResult == 0) {
                    // Check if both decks have at least five cards for a tiebreaker
                    if (player1Deck.size() >= 5 && player2Deck.size() >= 5) {
                        textSize(30);
                        text("Tie Breaker", width / 2, (height / 2) - 40);
                        delay(500);
                        //pause for the tie breaker



                        player1TieBreakerCard.draw(this, 200);
                        player2TieBreakerCard.draw(this, 550);

                        // compar the tie breaker so it will update the win count
                        int tieBreakerResult = player1TieBreakerCard.compare(player2TieBreakerCard);
                        if (tieBreakerResult > 0) {
                            player1WinCount++;
                        } else if (tieBreakerResult < 0) {
                            player2WinCount++;
                        }
                    }
                }
            }
        }
        // After round check for winner
        if (player1Deck.isEmpty()) {
            textSize(30);
            text("Player 2 Wins the Game!", width / 2, height / 2);
            return;
        } else if (player2Deck.isEmpty()) {
            textSize(30);
            text("Player 1 Wins the Game!", width / 2, height / 2);
            return;
        }
    }




}