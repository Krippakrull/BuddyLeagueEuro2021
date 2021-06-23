package io.krippakrull.github.buddyleague_euro_2021.services;

import io.krippakrull.github.buddyleague_euro_2021.models.Prediction;
import io.krippakrull.github.buddyleague_euro_2021.models.Score;

public class GameAndPredictionUpdate {
    // add methods for periodically querying API 2h after game start, maybe from game_id and database...
    // then find all predictions with that game_id once the game has a winner and


    private void updateUserPoints(Prediction prediction) {
        //Get prediction from database HERE
        if (prediction.getWinner().equals(prediction.getGame().getWinner())) {
            prediction.getUser().setPoints(+1);
        }
        for (Score score : prediction.getScores()) {
            if (score.getAwayScore() == prediction.getGame().getAwayTeamScore()
                    && score.getHomeScore() == prediction.getGame().getHomeTeamScore()) {
                prediction.getUser().setPoints(prediction.getUser().getPoints() + 1);
            }

        }
    }
}
