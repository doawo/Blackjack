package players;

import deck.BlackjackCard;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<BlackjackCard> _currentHand = new ArrayList<BlackjackCard>();

    public Hand() {
    }

    public void addCard(BlackjackCard card){
        _currentHand.add(card);
    }

    public List<Integer> getScores() {

        List<Integer> totalScores = new ArrayList<Integer>();

        for(int i = 0; i < _currentHand.size(); i++) {
            totalScores.add(_currentHand.get(i).get_gameValue());
        }

        return totalScores;
    }

    public int resolveScore() {

        int total = 0;

        for(int i = 0; i < _currentHand.size(); i++){
            total += _currentHand.get(i).get_gameValue();
        }

        return total;
    }

    public void removeHand(){
        this._currentHand.clear();
    }

    public BlackjackCard getFirstCard(){
        return this._currentHand.get(0);
    }

    public List<BlackjackCard> get_currentHand() {
        return _currentHand;
    }

    public void set_currentHand(List<BlackjackCard> _currentHand) {
        this._currentHand = _currentHand;
    }
}
