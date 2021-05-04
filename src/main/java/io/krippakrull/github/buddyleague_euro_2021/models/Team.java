package io.krippakrull.github.buddyleague_euro_2021.models;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "teams")
public class Team {
    private Integer teamId;
    private String teamName;
    private String flagUrl;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamId.equals(team.teamId) && teamName.equals(team.teamName) && Objects.equals(flagUrl, team.flagUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, teamName, flagUrl);
    }
}
