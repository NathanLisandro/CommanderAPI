package Service;

import Models.Deck;
import Repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeckService {
    @Autowired
    private DeckRepository deckRepository;

    public Deck createDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    public Optional<Deck> getDeckById(Long id) {
        return deckRepository.findById(id);
    }
}
