package io.krippakrull.github.buddyleague_euro_2021.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "teams")
public class Team {
    private Integer teamId;
    private String teamName;

    @Id
    @Column(name = "team_id", nullable = false)
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Basic
    @Column(name = "team_name", nullable = false, length = 50)
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (teamId != null ? !teamId.equals(team.teamId) : team.teamId != null) return false;
        if (teamName != null ? !teamName.equals(team.teamName) : team.teamName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teamId != null ? teamId.hashCode() : 0;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        return result;
    }
}
