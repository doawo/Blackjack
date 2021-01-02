package deck;

import enums.Suit;

public class Card {
    private Suit _suit;
    private int _faceValue;

    public Card() {
    }

    public Card(Suit _suit, int _faceValue) {
        this._suit = _suit;
        this._faceValue = _faceValue;
    }

    public static String translateFaceCard(BlackjackCard card){
        if (card.get_faceValue() == 1)
            return "ACE";
        else if (card.get_faceValue() == 11)
            return "JACK";
        else if (card.get_faceValue() == 12)
            return "QUEEN";
        else if (card.get_faceValue() == 13)
            return "KING";
        else
            return "" + card.get_faceValue();
    }

    public Suit get_suit() {
        return _suit;
    }

    public void set_suit(Suit _suit) {
        this._suit = _suit;
    }

    public int get_faceValue() {
        return _faceValue;
    }

    public void set_faceValue(int _faceValue) {
        this._faceValue = _faceValue;
    }
}
