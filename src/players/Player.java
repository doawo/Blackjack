package players;

import enums.AccountStatus;
import datatypes.Person;

public class Player extends BasePlayer{
    private int _bet, _totalCash;

    public Player(int _bet, int _totalCash) {
        this._bet = _bet;
        this._totalCash = _totalCash;
    }

    public Player(String _id, String _password, double _balance, AccountStatus _status, Person _person, Hand hand, int _bet, int _totalCash) {
        super(_id, _password, _balance, _status, _person, hand);
        this._bet = _bet;
        this._totalCash = _totalCash;
    }
    
    public int get_bet() {
        return _bet;
    }

    public void set_bet(int _bet) {
        this._bet = _bet;
    }

    public int get_totalCash() {
        return _totalCash;
    }

    public void set_totalCash(int _totalCash) {
        this._totalCash = _totalCash;
    }
}
