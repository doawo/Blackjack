package players;

import enums.AccountStatus;
import datatypes.*;

public class Dealer extends BasePlayer{
    public Dealer() {
    }

    public Dealer(String _id, String _password, double _balance, AccountStatus _status, Person _person, Hand hand) {
        super(_id, _password, _balance, _status, _person, hand);
    }

}
