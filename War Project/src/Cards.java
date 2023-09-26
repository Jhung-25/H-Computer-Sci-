import processing.core.PApplet;
import processing.core.PImage;

public class Cards{
    private int numbers;
    private int suit;
    PImage img, spriteSheet;



    //1 = clubs
    //2 = hearts
    //3 = spades
    //4 = diamonds
    // jack = 11
    // queen = 12
    // king = 13
    //ace = 14

    public void draw(PApplet p, int x) {
        //card draw function draws the card based on its suit and value
        int srcX = 1;
        int srcY = 1;

        if (spriteSheet == null) {
            spriteSheet = p.loadImage("spriteSheet.png");
        }

        img = p.createImage(140, 190, PApplet.ARGB);
        // for each suit and value of card find the appropite photo from sprite sheet
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