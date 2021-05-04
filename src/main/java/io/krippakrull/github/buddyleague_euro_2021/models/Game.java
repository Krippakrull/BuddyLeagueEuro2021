//package io.krippakrull.github.buddyleague_euro_2021.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//@Entity(name = "games")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//public class Game {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer gameId;
//    private Timestamp startTime;
//    private Integer winner; //0 = draw, 1 = home team, 2 = away team
//    private Integer score; //2 digit inte
//
//    public Integer getGameId() {
//        return gameId;
//    }
//
//    public void setGameId(Integer gameId) {
//        this.gameId = gameId;
//    }
//
//
//    public Timestamp getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(Timestamp startTime) {
//        this.startTime = startTime;
//    }
//
//    public Integer getWinner() {
//        return winner;
//    }
//
//    public void setWinner(Integer winner) {
//        this.winner = winner;
//    }
//
//    public Integer getScore() {
//        return score;
//    }
//
//    public void setScore(Integer score) {
//        this.score = score;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Game game = (Game) o;
//
//        if (gameId != null ? !gameId.equals(game.gameId) : game.gameId != null) return false;
//        if (startTime != null ? !startTime.equals(game.startTime) : game.startTime != null) return false;
//        if (winner != null ? !winner.equals(game.winner) : game.winner != null) return false;
//        if (score != null ? !score.equals(game.score) : game.score != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = gameId != null ? gameId.hashCode() : 0;
//        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
//        result = 31 * result + (winner != null ? winner.hashCode() : 0);
//        result = 31 * result + (score != null ? score.hashCode() : 0);
//        return result;
//    }
//}
