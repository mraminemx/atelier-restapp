package co.tenisu.atelierrestapp.service.impl;

import co.tenisu.atelierrestapp.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import co.tenisu.atelierrestapp.dto.StatisticResponseDto;
import co.tenisu.atelierrestapp.repository.PlayerRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Percentage.withPercentage;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@ActiveProfiles("test")
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=none")
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlayerServiceImplTest {

    @Autowired
    PlayerRepository playerRepository;

    private PlayerServiceImpl playerService;

    @BeforeEach
    public void setup() {
        playerService = new PlayerServiceImpl(playerRepository);
    }

    @Test
    @Sql("classpath:data/sql/noplayers.sql")
    void testGetStatisticsWithNoPlayers() {
        StatisticResponseDto statistics = playerService.getStatistics();
        assertThat(statistics.getAverageIMC()).isNull();
        assertThat(statistics.getMedianHeight()).isNull();
        assertThat(statistics.getCountryWithHighestWinRatio()).isNull();
    }

    @Test
    @Sql("classpath:data/sql/players.sql")
    void testGetStatisticsWithPlayers() {
        StatisticResponseDto statistics = playerService.getStatistics();
        assertThat(statistics.getAverageIMC()).isCloseTo(23357.83, withPercentage(10.0));
        assertThat(statistics.getMedianHeight()).isCloseTo(185.0, withPercentage(10.0));
        assertThat(statistics.getCountryWithHighestWinRatio()).isEqualTo("SRB");
    }

    @Test
    @Sql("classpath:data/sql/players.sql")
    void testGetPlayerById() {
        Player player = playerService.getPlayerById(Long.valueOf(95));
        assertThat(player.getFirstname()).isEqualToIgnoringCase("Venus");
        assertThat(player.getLastname()).isEqualToIgnoringCase("Williams");
    }

    @Test
    @Sql("classpath:data/sql/players.sql")
    void testGetAllPlayersOrderByRank() {
        List<Player> players = playerService.getAllPlayersOrderByRank();
        assertThat(players.size()).isEqualTo(5);
        Integer rankFirstPlayer = players.get(1).getData().getRank();
        Integer rankLastPlayer = players.get(players.size()-1).getData().getRank();
        assertThat(rankFirstPlayer).isLessThan(rankLastPlayer);
    }
}