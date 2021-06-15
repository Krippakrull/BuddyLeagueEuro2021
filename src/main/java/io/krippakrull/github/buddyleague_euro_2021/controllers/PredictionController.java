package io.krippakrull.github.buddyleague_euro_2021.controllers;

import io.krippakrull.github.buddyleague_euro_2021.models.*;
import io.krippakrull.github.buddyleague_euro_2021.payloads.request.PredictionRequest;
import io.krippakrull.github.buddyleague_euro_2021.repositories.GameRepository;
import io.krippakrull.github.buddyleague_euro_2021.repositories.PredictionRepository;
import io.krippakrull.github.buddyleague_euro_2021.repositories.TeamRepository;
import io.krippakrull.github.buddyleague_euro_2021.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//TODO: Fix SonarLint problem with demanding a DTO for team
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    @Autowired
    private PredictionRepository predictionRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Prediction> list() {
        return predictionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Prediction get (@PathVariable Long id) {
        return predictionRepository.getOne(id);
    }

    @GetMapping
    @RequestMapping("/byuser/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Prediction> getByUser (@PathVariable Long id) {
        return predictionRepository.findByUserId(id);
    }


    @PostMapping
    public Prediction create(@RequestBody final Prediction prediction) {
        return predictionRepository.saveAndFlush(prediction);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //also need to check for children records before delete
        //homework?
        predictionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Prediction update(@PathVariable Long id, @RequestBody Prediction prediction) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need the changes
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Prediction existingPrediction = predictionRepository.getOne(id);
        BeanUtils.copyProperties(prediction, existingPrediction, "id");
        return predictionRepository.saveAndFlush(existingPrediction);
    }

    @PostMapping("/predict")
    public Prediction predict(@RequestBody PredictionRequest predictionRequest) {
        Game game = gameRepository.getOne(predictionRequest.getGameId());
        User user = userRepository.getOne(predictionRequest.getUserId());
        String winner = predictionRequest.getWinner();
        Prediction prediction = new Prediction(game, user);
        if (winner.equals("home")) {
            prediction.setWinner(Winner.HOME_TEAM);
        }
        else if(winner.equals("away")) {
            prediction.setWinner(Winner.AWAY_TEAM);
        }
        else {
            prediction.setWinner(Winner.DRAW);
        }

        Set<Score> scores = predictionRequest.getScores();
        prediction.setScores(scores);
        return predictionRepository.saveAndFlush(prediction);
    }

    @GetMapping
    @RequestMapping("/byuser/{uid}/{gid}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Prediction getByUserAndGame (@PathVariable Long uid, @PathVariable Long gid) {
        if (predictionRepository.existsByUserIdAndGameId(uid, gid)) {
            return predictionRepository.findByUserIdAndGameId(uid, gid);
        }
        return null;
    }

    @GetMapping
    @RequestMapping("/apidata")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String getApiData () {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.football-data.org/v2/competitions/2018/")
                .defaultHeader("X-Auth-Token", "13b739b1474f45b5a4091a5f3a4d9948")
                .build();
        String Json = webClient.get()
                .uri("/teams/")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return Json;
    }

}
