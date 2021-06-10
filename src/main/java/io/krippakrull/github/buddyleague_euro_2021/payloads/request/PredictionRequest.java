package io.krippakrull.github.buddyleague_euro_2021.payloads.request;

import io.krippakrull.github.buddyleague_euro_2021.models.Score;
import io.krippakrull.github.buddyleague_euro_2021.models.Winner;

import java.util.Set;

import javax.validation.constraints.*;

public class PredictionRequest {
    @NotBlank
    private Long userId;

    @NotBlank
    private Long gameId;

    private String winner;

    private Set<Score> scores;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
}