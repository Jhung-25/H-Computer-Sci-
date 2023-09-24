import processing.core.*;

import java.util.ArrayList;

public class PlayGame extends PApplet {
    int buttonX, buttonY, buttonW, buttonH;
    int player1WinCount = 0;
    int player2WinCount = 0;

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
        warGame = new WarGame(); // Create an instance of WarGame
        ArrayList<Cards> deck = new ArrayList<Cards>();
        ArrayList<Cards> result = new ArrayList<Cards>(warGame.createDeck(deck));
        ArrayList<Cards> shuffled = new ArrayList<Cards>(warGame.shuffleDeck(result));
        player1Deck = new ArrayList<Cards>(warGame.p1Deck(shuffled));
        player2Deck = new ArrayList<Cards>(warGame.p2Deck(shuffled));
        warGame.war(player2Deck, player1Deck, 1);
        buttonW = 100;
        buttonH = 40;
        buttonX = width / 2 - buttonW / 2;
        buttonY = height / 2 - buttonH / 2;


    }

    public void draw() {
        background(255);
        if (mouseX >= buttonX && mouseX <= buttonX + buttonW && mouseY >= buttonY && mouseY <= buttonY + buttonH && mousePressed) {
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

        text("Let's Play War!", 40, 25);

        fill(0);
        textSize(20);
        text(mouseX + "," + mouseY, mouseX + 10, mouseY + 10);
        text("Let's Play War", 440, 155);
        text("Player1 Win Count:" + player1WinCount, 260, 400);
        text("Player2 Win Count:" + player2WinCount, 620, 400);
        text("Player 1 Deck Size:" + player1Deck.size(), 100, 10);
        text("Player 2 Deck Size:" + player2Deck.size(), 100, 50);
        player2Deck.get(1).draw(this, 200);
        player1Deck.get(1).draw(this, 550);


    }

    public void mousePressed() {
        // Check if mouse is pressed within the bounds of the rectangle
        if (mouseX > width / 2 - 60 && mouseX < width / 2 + 60 && mouseY > height / 2 - 20 && mouseY < height / 2 + 20) {
            println("Button Pressed!"); // Print message to console if the button is pressed
            if (warGame.war(player2Deck, player1Deck, 1) == 1) {
                player1WinCount++;
            }
            if (warGame.war(player2Deck, player1Deck, 1) == 2) {
                player2WinCount++;
            }

        }

    }
}