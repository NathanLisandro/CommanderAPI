package Service;

import Models.Card;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class ScryfallService {

    private final WebClient webClient;

    public ScryfallService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.scryfall.com").build();
    }

    public Card getCommander(String commanderName) {
        return this.webClient.get()
                .uri("/cards/named?exact={commanderName}", commanderName)
                .retrieve()
                .bodyToMono(Card.class)
                .block();
    }

    public List<Card> getCardsByColor(String colors) {
        return this.webClient.get()
                .uri("/cards/search?q=c:{colors}", colors)
                .retrieve()
                .bodyToFlux(Card.class)
                .collectList()
                .block();
    }
}
