package deck;

import enums.Suit;

public class BlackjackCard extends Card{
    private int _gameValue;

    public BlackjackCard(int _gameValue) {
        this._gameValue = _gameValue;
    }

    public BlackjackCard(Suit _suit, int _faceValue, int _gameValue) {
        super(_suit, _faceValue);
        this._gameValue = _gameValue;
    }

    public int translateGameValue(Card card){
        int gameValue;

        if(card.get_faceValue() == 1)
            return 11;
        else if(card.get_faceValue() <= 10)
            return card.get_faceValue();
        else if(card.get_faceValue() > 10)
            return 10;

        return 0;
    }

//    public BlackjackCard translateToBJValue(Card card){
//
//        Suit suit = card.get_suit();
//        int faceValue = card.get_faceValue();
//        int gameValue = 0;
//
//        if(card.get_faceValue() == 1)
//            gameValue = 11;
//        else if(card.get_faceValue() <= 10)
//            gameValue = card.get_faceValue();
//        else if(card.get_faceValue() > 10)
//            gameValue = 10;
//
//        BlackjackCard blackjackCard = new BlackjackCard(suit, faceValue, gameValue);
//
//        return blackjackCard;
//    }

    public int get_gameValue() {
        return _gameValue;
    }

    public void set_gameValue(int _gameValue) {
        this._gameValue = _gameValue;
    }
}
