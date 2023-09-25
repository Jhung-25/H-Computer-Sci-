import processing.core.PApplet;
import processing.core.PImage;

public class Cards{
    private int numbers;
    private int suit;
    PImage img, spriteSheet;

//    public void draw(PApplet p){
//        p.image('spriteSheet.png');
//    }

    //1 = clubs
    //2 = hearts
    //3 = spades
    //4 = diamonds
    // jack = 11
    // queen = 12
    // king = 13
    //ace = 14

    public void draw(PApplet p, int x) {
        //draw function for cards object takes in an x value for location and PApplet
        int srcX = 1;
        int srcY = 1;
        //as the class doesn't extnd PApplet I was not able to load sprite sheet outside of the draw function
        if (spriteSheet == null) {
            spriteSheet = p.loadImage("spriteSheet.png");
        }

        img = p.createImage(140, 190, PApplet.ARGB);
        // for each suit and value find the photto from the spriteSheet
        if (suit == 1) {
            if (numbers == 14) {
                img.copy(spriteSheet, srcX, srcY, 140, 190, 0, 0, 140, 190);
            } else {
                srcX = srcX + (140 * (numbers - 1));
                img.copy(spriteSheet, srcX, srcY, 140, 190, 0, 0, 140, 190);
            }
        }
        if (suit == 2) {
            srcY += 190;
            if (numbers == 14) {
                img.copy(spriteSheet, srcX, srcY, 140, 190, 0, 0, 140, 190);
            } else {
                srcX = srcX + (140 * (numbers - 1));
                img.copy(spriteSheet, srcX, srcY, 140, 190, 0, 0, 140, 190);
            }
        }
        if (suit == 3) {
            srcY += 190 * (suit - 1);
            if (numbers == 14) {
                img.copy(spriteSheet, srcX, srcY, 140, 190, 0, 0, 140, 190);
            } else {
                srcX = srcX + (140 * (numbers - 1));
                img.copy(spriteSheet, srcX, srcY, 140, 190, 0, 0, 140, 190);
            }
        }
        if (suit == 4) {
            srcY += 190 * (suit - 1);
            if (numbers == 14) {
                img.copy(spriteSheet, srcX, srcY, 140, 190, 0, 0, 140, 190);
            } else {
                srcX = srcX + (140 * (numbers - 1));
                img.copy(spriteSheet, srcX, srcY, 140, 190, 0, 0, 140, 190);
            }
        }

        p.image(img, x, 200); // Display the card at the specified x position
    }

    public Cards(int numbers, int suit){
        this.numbers = numbers;
        this.suit = suit;
    }
    public int getNumbers(){
        return numbers;
    }
    public int getSuit(){
        return suit;
    }
    @Override
    public String toString() {
        return numbers + "," + suit;

    }
    public int compare(Cards card){
        return Integer.compare(this.numbers, card.numbers);
    }
}
