package io.krippakrull.github.buddyleague_euro_2021.models;

import javax.persistence.*;

@Entity(name = "predictions")
public class Prediction {
    private Integer predictionId;
    private Integer winner;
    private Object scores;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id", nullable = false)
    private Game game;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @Id
    @Column(name = "prediction_id", nullable = false)
    public Integer getPredictionId() {
        return predictionId;
    }

    public void setPredictionId(Integer predictionId) {
        this.predictionId = predictionId;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public Object getScores() {
        return scores;
    }

    public void setScores(Object scores) {
        this.scores = scores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prediction that = (Prediction) o;

        if (predictionId != null ? !predictionId.equals(that.predictionId) : that.predictionId != null) return false;
        if (winner != null ? !winner.equals(that.winner) : that.winner != null) return false;
        if (scores != null ? !scores.equals(that.scores) : that.scores != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = predictionId != null ? predictionId.hashCode() : 0;
        result = 31 * result + (winner != null ? winner.hashCode() : 0);
        result = 31 * result + (scores != null ? scores.hashCode() : 0);
        return result;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
