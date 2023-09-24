import processing.core.*;

public class SpriteSheetParse extends PApplet{
    PImage img, spriteSheet;

    // track the keypress count
    int counter = 0;
    // dimensions of the cards and spacing in the spritesheet
    int spriteW = 140, spriteH = 190;
    int xGutter = 1, yGutter = 1;

    public static void main(String[] args) {
        PApplet.main(SpriteSheetParse.class);
    }

    public void settings() {
        size(1833,955);
    }
    public void setup() {
        // image containg all card faces and card backs
        spriteSheet = loadImage("spriteSheet.png");
        // the PImage for a card
        img = createImage(spriteW,spriteH,ARGB);

        extractCard(spriteSheet,img,0,0);
        textSize(16);
        fill(0);
    }

    public void draw() {
        background(spriteSheet);
        //background(200);x
        image(img,100,100);
        text(mouseX+","+mouseY,mouseX+10,mouseY + 10);
    }

    public void keyPressed() {
        counter++;
        int cursorX = (counter % 13) * (spriteW + xGutter);
        int cursorY = (counter / 13) * (spriteH + yGutter);
        extractCard(spriteSheet,img, cursorX, cursorY);
//        img.copy(spriteSheet,cursorX,cursorY,spriteW,spriteH, 0,0,spriteW,spriteH);
    }

    /*
    helper method that wraps the PImage copy method.
    copies the card at coordinate x,y from src into the dest.
     */
    public void extractCard(PImage src,PImage dest, int x, int y) {
        dest.copy(src,x,y,spriteW, spriteH, 0,0, spriteW, spriteH);
    }

}