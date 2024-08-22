package Controller;

import Models.Deck;
import Service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/decks")
public class DeckController {
    @Autowired
    private DeckService deckService;

    @PostMapping
    public ResponseEntity<Deck> createDeck(@RequestBody Deck deck) {
        Deck savedDeck = deckService.createDeck(deck);
        return ResponseEntity.ok(savedDeck);
    }

    @GetMapping("/{deckId}")
    public ResponseEntity<Deck> getDeck(@PathVariable Long deckId) {
        Optional<Deck> deck = deckService.getDeckById(deckId);
        return deck.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
