import processing.core.*;
import processing.core.PApplet;

public class SetupExample extends PApplet{
    jHungShape shape2;
    rectShape shape3,shape4,shape5,shape6,shape7,shape8,shape9,shape10,shape11,shape12,shape13,shape14;
    public static void main (String[] args) {
        PApplet.main(SetupExample.class.getSimpleName());
    }

    public void settings() {
        size(1016,1010);
    }

    public void setup() {
        // notice that I use color to create an integer
        // that represents red...
        // ... when you look in the constructor of ParentShape
        // the second parameter is declared as an int.
        noStroke();
        background(255);
        shape2= new jHungShape(508,467,640,640,0,0,0,0);
        fill(0);
        ellipse(508,467,640,640);
        shape3= new rectShape(56,530,324,96,35,69,149,255);
        shape4= new rectShape(235,643,900,8,255,255,255,255);
        shape5= new rectShape(606,339,335,329,202,0,15,255);
        shape6= new rectShape(167,589,673,12,255,255,255,255);
        shape7= new rectShape(68,799,887,60,0,0,0,0);
        shape8= new rectShape(285,815,422,13,255,255,255,255);
        shape9= new rectShape(408,339,8,405,255,255,255,255);
        shape10= new rectShape(376,396,40,32,255,255,255,255);
        shape11= new rectShape(426,217,9,500,255,217,0,255);
        shape2.draw();
        shape3.draw();
        shape4.draw();
        shape5.draw();
        shape6.draw();
        shape7.draw();
        shape8.draw();
        shape9.draw();
        shape10.draw();
        shape11.draw();




//        someShape.draw();
//        rectShape exShape = new rectShape(100,100,100,100,100,40,50,14);
//
//        fill(255);
//        background(255);
//        fill(0);
//        ellipse(508,467,640,640);
//        fill(35,69,149,255);
//        rect(56,530,324,96);

//        fill(255);
//        rect(235,643,900,8);

//        fill(202,0,15,255);
//        rect(606,339,335,329);
//        fill(255);
//        rect(167,589,673,12);
//        fill(0);
//        rect(68,799,887,60);
//        fill(255);
//        rect(285,815,422,13);
//        rect(408,339,8,405);
//        rect(376,396,40,32);
//        fill(255,217,0,255);
//        rect(426,217,9,500);
//        fill(255);
//        exShape.draw();
    }

    /*Declare a class INSIDE of the class
    that extends PApplet. If you do it this way
    then you can use all of the Processing functions and variables
    inside of your Shape class.
     */
    class jHungShape {
        int x,y,w,h;
        int color1,color2,color3,colorA;
        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

        int width() {
            return w;
        }

        int height() {
            return h;
        }

        void setColor(int c) {
//        shapeColor = c;
        }

        jHungShape(int x,int y, int w, int h, int color1,int color2,int color3,int colorA) {
            this.x = x;
            this.y =y;
            this.w =w;
            this.h = h;
            this.color1 = color1;
            this.color2=color2;
            this.color3=color3;
            this.colorA=colorA;
        }

        public void draw() {
            fill(color1,color2,color3,colorA);
            ellipse(x,y,w,h);
        }
    }

    /*
    Another inner class. This one extends the other inner class...
    And we can use all of the Processing goodness inside of this
    one too!
     */
    class rectShape extends jHungShape {
        rectShape(int x,int y, int w, int h, int c1,int c2, int c3, int cA) {
            // call the ParentShape constructor
            // which will setup the properties
            // this color is cyan, btw.
            super(x,y,w,h,c1,c2,c3,cA);
        }

        public void draw() {
            fill(color1,color2,color3,colorA);
            rect(x,y,w,h);
        }
    }
}
