import processing.core.*;
import processing.core.PApplet;

public class SetupExample extends PApplet{
    ParentShape someShape;
    public static void main (String[] args) {
        PApplet.main(SetupExample.class.getSimpleName());
    }

    public void settings() {
        size(400,400);
    }

    public void setup() {
        background(255);
        // notice that I use color to create an integer
        // that represents red...
        // ... when you look in the constructor of ParentShape
        // the second parameter is declared as an int.
        someShape = new ParentShape(100,color(255,0,0));
        someShape.draw();
        ExtendedShape exShape = new ExtendedShape();
        exShape.draw();
    }

    /*Declare a class INSIDE of the class
    that extends PApplet. If you do it this way
    then you can use all of the Processing functions and variables
    inside of your Shape class.
     */
    class ParentShape {
        int someProperty;
        int forYouJarret;
        ParentShape(int aParameter, int aColorForJarret) {
            someProperty = aParameter;
            forYouJarret = aColorForJarret;
        }

        public void draw() {
            fill(forYouJarret);
            ellipse(width / 2, height /2, someProperty,someProperty);
        }
    }

    /*
    Another inner class. This one extends the other inner class...
    And we can use all of the Processing goodness inside of this
    one too!
     */
    class ExtendedShape extends ParentShape {
        ExtendedShape() {
            // call the ParentShape constructor
            // which will setup the properties
            // this color is cyan, btw.
            super(300,color(0,255,255));
        }

        public void draw() {
            fill(forYouJarret);
            square(width/2,height/2,someProperty);
        }
    }
}
