import processing.core.*;
import java.util.ArrayList;
import processing.core.PApplet;

public class Main extends PApplet{

    public static void main(String[] args) {

        PApplet.main(Main.class.getSimpleName());

    }

    @Override









    public void settings() {

        size(1016,1010);

    }


    public void setup() {
        noStroke();
        background(255,0,0);
        ArrayList<jHungShape>shapes=new ArrayList<jHungShape>();



    }


    public void draw() {

//        PImage img;
//        img =loadImage("gorin.png");
//        image(img,0,0);
        fill(255);
        background(255);
        fill(0);
     ellipse(508,467,640,640);
     fill(35,69,149,255);
     rect(56,530,324,96);
     fill(255);
     rect(235,643,900,8);
     fill(202,0,15,255);
     rect(606,339,335,329);
     fill(255);
     rect(167,589,673,12);
     fill(0);
     rect(68,799,887,60);
     fill(255);
     rect(285,815,422,13);
     rect(408,339,8,405);
     rect(376,396,40,32);
     fill(255,217,0,255);
     rect(426,217,9,500);
     fill(255);

        fill(100);
        textSize(104);
        text(mouseX +", "+mouseY,100,100);
    }
}
class jHungShape{
    float x, y;
    float width, height;
  int shapeColor;
//

    jHungShape(float x,float y,float width,float height,int shapeColor){
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
            this.shapeColor=shapeColor;
    }


    public void draw(){
        System.out.println("I don't do anything");
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }

    float width() {
        return width;
    }

    float height() {
        return height;
    }

    void setColor(int c) {
//        shapeColor = c;
    }

    void setX(float x) {
        this.x = x;
    }

    void setY(float y) {
        this.y = y;
    }
}
class ellipseShape extends jHungShape {

    ellipseShape(float x, float y, float w, float h, int c) {
        super();

    }
    public void draw(){
        fill(shapeColor);
        ellipse(x,y,w,h);
    }

}

class rectShape extends jHungShape {
    rectShape(float x, float y, float w, float h, int c) {
        super();

    }


}
