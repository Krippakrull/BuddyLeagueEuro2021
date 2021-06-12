package io.krippakrull.github.buddyleague_euro_2021.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "predictions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Winner winner;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "prediction", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "prediction_id")
    @JsonManagedReference
    private Set<Score> scores;

    public Prediction() {
    }

    public Prediction(Game game, User user) {
        this.game = game;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long predictionId) {
        this.id = predictionId;
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prediction that = (Prediction) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (winner != null ? !winner.equals(that.winner) : that.winner != null) return false;
        if (scores != null ? !scores.equals(that.scores) : that.scores != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
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
