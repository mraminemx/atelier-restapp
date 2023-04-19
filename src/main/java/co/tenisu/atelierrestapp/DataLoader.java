package co.tenisu.atelierrestapp;

import co.tenisu.atelierrestapp.entity.Player;
import co.tenisu.atelierrestapp.entity.PlayerList;
import co.tenisu.atelierrestapp.repository.PlayerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@Profile("!test")
@Component
public class DataLoader {

    @Autowired
    private PlayerRepository playerRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

    @PostConstruct
    public void loadData() throws IOException, URISyntaxException {
        // Charger le fichier JSON
        String filename = "players.json";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data/" + filename);
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            LOGGER.debug("Chargement du fichier json {} en base H2", filename);
            ObjectMapper objectMapper = new ObjectMapper();
            PlayerList playerList = objectMapper.readValue(inputStream, PlayerList.class);

            // Enregistrer les joueurs dans la base de données
            List<Player> players = Arrays.asList(playerList.getPlayers());
            playerRepository.saveAll(players);
        }
    }
}
