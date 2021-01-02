package deck;

import java.time.LocalDate;
import java.util.*;

import enums.Suit;

public class Deck {
    private LocalDate _creationDate;
    private List<BlackjackCard> _blackjackCardDeck;

    public Deck() {
    }

    public Deck(LocalDate _creationDate, List<BlackjackCard> _blackjackCardDeck) {
        this._creationDate = _creationDate;
        this._blackjackCardDeck = _blackjackCardDeck;
    }

    public Deck createBJDeck(){

        List<BlackjackCard> bjDeck = new ArrayList<BlackjackCard>();
        List<Card> normalDeck = createNormalDeck();
        BlackjackCard tempCard = new BlackjackCard(0);

        for (int i = 0; i < normalDeck.size(); i++){
            BlackjackCard blackjackCard = new BlackjackCard(normalDeck.get(i).get_suit(), normalDeck.get(i).get_faceValue(), tempCard.translateGameValue(normalDeck.get(i)));
            bjDeck.add(blackjackCard);
        }

        Deck deck = new Deck(LocalDate.now(), bjDeck);

        return deck;
    }

    public List<Card> createNormalDeck() {
        List<Card> _cardDeck = new ArrayList<Card>();
        Card card;

        // 0 = Clubs 1 = Diamonds 2 = Hearts 3 = Spades

        for (int suit = 0; suit < 4; suit++) {
            for (int cardRank = 1; cardRank <= 13; cardRank++) {
                switch (suit){
                    case 0:
                        card = new Card(Suit.CLUB, cardRank);
                        _cardDeck.add(card);
                        break;
                    case 1:
                        card = new Card(Suit.DIAMOND, cardRank);
                        _cardDeck.add(card);
                        break;
                    case 2:
                        card = new Card(Suit.HEART, cardRank);
                        _cardDeck.add(card);
                        break;
                    case 3:
                        card = new Card(Suit.SPADE, cardRank);
                        _cardDeck.add(card);
                        break;
                }
            }
        }

        return _cardDeck;
    }

    public BlackjackCard getFirstCard(){
        return this._blackjackCardDeck.get(0);
    }

    public BlackjackCard getRandomCard(int deckInd){
        Random rand = new Random();
        int randCardInd = rand.nextInt((this._blackjackCardDeck.size()));

        BlackjackCard card = this._blackjackCardDeck.get(randCardInd);

        removeCard(randCardInd);

        return card;
    }

    public void removeCard(int index){
        this._blackjackCardDeck.remove(index);
    }

    public LocalDate get_creationDate() {
        return _creationDate;
    }

    public void set_creationDate(LocalDate _creationDate) {
        this._creationDate = _creationDate;
    }

    public List<BlackjackCard> get_blackjackCardDeck() {
        return _blackjackCardDeck;
    }

    public void set_blackjackCardDeck(List<BlackjackCard> _blackjackCardDeck) {
        this._blackjackCardDeck = _blackjackCardDeck;
    }
}
