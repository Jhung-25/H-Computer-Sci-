import java.util.ArrayList;
import java.util.Collections;

public class WarGame {
    public ArrayList createDeck(ArrayList<Cards> deck){
        //jack = 11
        //queen = 12
        //king = 13
        //ace = 14
        for(int n = 1; n < 5; n++){
            for(int i = 2; i < 15; i++){
                deck.add(new Cards(i,n));
            }

        }

        return deck;
    }

    public ArrayList shuffleDeck(ArrayList<Cards> deck){
        Collections.shuffle(deck);
        return deck;
    }
    public ArrayList p1Deck(ArrayList<Cards> deck){
        ArrayList<Cards> p1Deck = new ArrayList<Cards>();
        for(int i = 0; i < deck.size()/2; i++){
            p1Deck.add(deck.get(i));
        }
        return p1Deck;

    }

    public ArrayList p2Deck(ArrayList<Cards> deck){
        ArrayList<Cards> p2Deck = new ArrayList<Cards>();
        for(int i = deck.size()/2; i < deck.size(); i++){
            p2Deck.add(deck.get(i));
        }
        return p2Deck;
    }
    //compares the cards to see which one is greater
    public int war(ArrayList<Cards> p1Deck, ArrayList<Cards> p2Deck, int currIndex){
        //reset index if at zero

        if (p1Deck.isEmpty()) {
            System.out.println("player 2 wins!");
            System.exit(0);
        } else if (p2Deck.isEmpty()) {
            System.out.println("player 1 wins");
            System.exit(0);
        }
        int win;
        if(p1Deck.get(currIndex).compare(p2Deck.get(currIndex)) < 0){
            p1Winner(p1Deck, p2Deck, currIndex);

            return 1;
        }
        else if (p1Deck.get(currIndex).compare(p2Deck.get(currIndex)) > 0){
            p2Winner(p1Deck, p2Deck, currIndex);

            return 2;
        }
        else{
            tie(p1Deck, p2Deck, currIndex);
            return 0;
        }
    }
    //adding/removing the card from an index depending on if it wins or loses
    public void p1Winner(ArrayList<Cards> p1Deck, ArrayList<Cards> p2Deck, int currIndex){
        p1Deck.add(p2Deck.get(currIndex));
        p1Deck.add(p1Deck.get(currIndex));
        p1Deck.remove(currIndex);

        p2Deck.remove(currIndex);

    }

    public void  p2Winner(ArrayList<Cards> p1Deck, ArrayList<Cards> p2Deck, int currIndex){
        p2Deck.add(p1Deck.get(currIndex));
        p2Deck.add(p2Deck.get(currIndex));
        p2Deck.remove(currIndex);

        p1Deck.remove(currIndex);
    }

    public  void tie(ArrayList<Cards> p1Deck, ArrayList<Cards> p2Deck, int currIndex) {
        //determines winner if deck(s) are too small
        if(p1Deck.size() <= 5){
            System.out.println("Player 2 wins");
            System.exit(0);

        }
        if (p2Deck.size() <= 5) {
            System.out.println("Player 1 wins");
            System.exit(0);
        }
        //adds new cards new cards to deck
        if(war(p1Deck, p2Deck, currIndex+4)==1) {
            for(int i=0; i<4; i++) {
                p1Winner(p1Deck, p2Deck, currIndex);
            }
        }
        else if(war(p1Deck, p2Deck, currIndex+4)==2) {
            for(int i=0; i<4; i++) {
                p2Winner(p1Deck, p2Deck, currIndex);
            }
        }

    }

}
