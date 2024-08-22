package br.commanderapi.CommanderAPI;

import Models.Deck;
import Repository.DeckRepository;
import Service.DeckService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DeckServiceTest {

    @Autowired
    private DeckService deckService;

    @MockBean
    private DeckRepository deckRepository;

    @Test
    public void testCreateDeck() {
        Deck deck = new Deck();
        Mockito.when(deckRepository.save(deck)).thenReturn(deck);

        Deck createdDeck = deckService.createDeck(deck);

        assertNotNull(createdDeck);
        Mockito.verify(deckRepository).save(deck);
    }

    @Test
    public void testGetDeckById() {
        Deck deck = new Deck();
        Mockito.when(deckRepository.findById(1L)).thenReturn(Optional.of(deck));

        Optional<Deck> foundDeck = deckService.getDeckById(1L);

        assertTrue(foundDeck.isPresent());
        Mockito.verify(deckRepository).findById(1L);
    }
}