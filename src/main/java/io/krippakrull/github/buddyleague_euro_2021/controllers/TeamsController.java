package io.krippakrull.github.buddyleague_euro_2021.controllers;

import io.krippakrull.github.buddyleague_euro_2021.models.Team;
import io.krippakrull.github.buddyleague_euro_2021.repositories.TeamRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO: Fix SonarLint problem with demanding a DTO for team
@RestController
@RequestMapping("/api/v1/teams")
public class TeamsController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public List<Team> list() {
        return teamRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Team get (@PathVariable Long id) {
        return teamRepository.getOne(id);
    }

    @PostMapping
    public Team create(@RequestBody final Team team) {
        return teamRepository.saveAndFlush(team);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //also need to check for children records before delete
        //homework?
        teamRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Team update(@PathVariable Long id, @RequestBody Team team) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need the changes
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Team existingTeam = teamRepository.getOne(id);
        BeanUtils.copyProperties(team, existingTeam, "teamId");
        return teamRepository.saveAndFlush(existingTeam);
    }
}
