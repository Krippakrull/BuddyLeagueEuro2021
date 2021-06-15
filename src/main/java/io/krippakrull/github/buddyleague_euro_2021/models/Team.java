package io.krippakrull.github.buddyleague_euro_2021.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "teams")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Team {
    @Id
    private Long id;
    private String teamName;
    private String flagUrl;

//    @OneToMany(mappedBy = "home_games")
//    private Set<Game> homeGames = new HashSet<>();
//
//    @OneToMany(mappedBy = "away_games")
//    private Set<Game> awayGames = new HashSet<>();


    public Team() {
    }

    public Team(Long id, String teamName, String flagUrl) {
        this.id = id;
        this.teamName = teamName;
        this.flagUrl = flagUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long teamId) {
        this.id = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

//    public Set<Game> getHomeGames() {
//        return homeGames;
//    }
//
//    public void setHomeGames(Set<Game> homeGames) {
//        this.homeGames = homeGames;
//    }
//
//    public Set<Game> getAwayGames() {
//        return awayGames;
//    }
//
//    public void setAwayGames(Set<Game> awayGames) {
//        this.awayGames = awayGames;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id.equals(team.id) && teamName.equals(team.teamName) && Objects.equals(flagUrl, team.flagUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, flagUrl);
    }
}
