package deck;

import java.util.*;

public class Shoe {
    private int _numberOfDecks;
    private Shoe _shoe;
    private List<Deck> _decks = new ArrayList<Deck>();

    public Shoe() {
    }

    public Shoe(int _numberOfDecks) {
        this._numberOfDecks = _numberOfDecks;
    }

    public void createShoe(){
        Deck tempDeck = new Deck();

        for(int i = 0; i < _numberOfDecks; i++){
            Deck BJDeck = tempDeck.createBJDeck();
            shuffle(BJDeck);
            this._decks.add(BJDeck);
        }
    }

    public void shuffle(Deck deck){
        Collections.shuffle(deck.get_blackjackCardDeck());
    }

    public Deck getSpecificDeck(int index){
        return this._decks.get(index);
    }

    public List<Deck> get_decks() {
        return _decks;
    }

    public void set_decks(List<Deck> _decks) {
        this._decks = _decks;
    }

    public int get_numberOfDecks() {
        return _numberOfDecks;
    }

    public void set_numberOfDecks(int _numberOfDecks) {
        this._numberOfDecks = _numberOfDecks;
    }
}
