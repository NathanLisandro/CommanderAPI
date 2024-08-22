package Models;

import jakarta.persistence.*;

import java.util.List;
@Entity

public class Deck {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne(cascade = CascadeType.ALL)
        private Card commander;

        @OneToMany(cascade = CascadeType.ALL)
        private List<Card> cards;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Card getCommander() {
            return commander;
        }

        public void setCommander(Card commander) {
            this.commander = commander;
        }

        public List<Card> getCards() {
            return cards;
        }

        public void setCards(List<Card> cards) {
            this.cards = cards;
        }
}
