package Repository;

import Models.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Long> {
}
