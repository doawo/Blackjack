package players;

import enums.AccountStatus;
import datatypes.Person;

public class BasePlayer {
    private String _id, _password;
    private double _balance;
    private AccountStatus _status;
    private Person _person;
    private Hand hand;

    public BasePlayer() {
    }

    public BasePlayer(String _id, String _password, double _balance, AccountStatus _status, Person _person, Hand hand) {
        this._id = _id;
        this._password = _password;
        this._balance = _balance;
        this._status = _status;
        this._person = _person;
        this.hand = hand;
    }

    public boolean resetPassword(){
        return true;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public double get_balance() {
        return _balance;
    }

    public void set_balance(double _balance) {
        this._balance = _balance;
    }

    public AccountStatus get_status() {
        return _status;
    }

    public void set_status(AccountStatus _status) {
        this._status = _status;
    }

    public Person get_person() {
        return _person;
    }

    public void set_person(Person _person) {
        this._person = _person;
    }

    public Hand getHands() {
        return hand;
    }

    public void setHands(Hand[] hands) {
        this.hand = hand;
    }
}
