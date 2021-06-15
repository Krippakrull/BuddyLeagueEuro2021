// TODO: refactor and move token to config, break out webclient and methods

package io.krippakrull.github.buddyleague_euro_2021.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.krippakrull.github.buddyleague_euro_2021.models.Game;
import io.krippakrull.github.buddyleague_euro_2021.models.Team;
import io.krippakrull.github.buddyleague_euro_2021.models.Winner;
import io.krippakrull.github.buddyleague_euro_2021.repositories.GameRepository;
import io.krippakrull.github.buddyleague_euro_2021.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FetchInitialData {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    GameRepository gameRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void runAll() {
        try {
            fetchAndStoreTeams();
            fetchAndStoreMatches();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void fetchAndStoreTeams() throws Exception{



        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.football-data.org/v2/competitions/2018/")
                .defaultHeader("X-Auth-Token", "13b739b1474f45b5a4091a5f3a4d9948")
                .build();
        String json = webClient.get()
                .uri("/teams/")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(json);

        ArrayNode arrayNode = (ArrayNode) root.get("teams");
        if (arrayNode.isArray()) {
            for (JsonNode jsonNode : arrayNode) {

                //System.out.println(jsonNode);
                long teamId = jsonNode.get("id").asLong();
                String teamName = jsonNode.get("name").asText();
                String flagUrl = jsonNode.get("crestUrl").asText();

                Team team = new Team(teamId, teamName, flagUrl);

                teamRepository.saveAndFlush(team);

            }
        }
    }

    public void fetchAndStoreMatches() throws Exception{



        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.football-data.org/v2/competitions/2018/")
                .defaultHeader("X-Auth-Token", "13b739b1474f45b5a4091a5f3a4d9948")
                .build();
        String json = webClient.get()
                .uri("/matches/")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(json);

        ArrayNode arrayNode = (ArrayNode) root.get("matches");
        if (arrayNode.isArray()) {
            for (JsonNode jsonNode : arrayNode) {

                //System.out.println(jsonNode);
                long teamId = jsonNode.get("id").asLong();

                String date = jsonNode.get("utcDate").asText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
                Date parsedDate = dateFormat.parse(date);
                Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

                String winString = jsonNode.at("/score/winner").asText();
                Winner winner = null;

                if (winString.equals("DRAW")) {
                    winner = Winner.DRAW;
                }
                if (winString.equals("HOME_TEAM")) {
                    winner = Winner.HOME_TEAM;
                }
                if (winString.equals("AWAY_TEAM")) {
                    winner = Winner.AWAY_TEAM;
                }

                int homeTeamScore = jsonNode.at("/score/fullTime/homeTeam").asInt();
                int awayTeamScore = jsonNode.at("/score/fullTime/awayTeam").asInt();
                long homeTeam = jsonNode.at("/homeTeam/id").asLong();
                long awayTeam = jsonNode.at("/awayTeam/id").asLong();


                if (homeTeam != 0 && awayTeam != 0) {
                    Game game = new Game(teamId,
                            timestamp,
                            teamRepository.getOne(homeTeam),
                            teamRepository.getOne(awayTeam),
                            winner,
                            homeTeamScore,
                            awayTeamScore);

                    gameRepository.saveAndFlush(game);
                }


            }
        }
    }

}

