package io.krippakrull.github.buddyleague_euro_2021.controllers;

import io.krippakrull.github.buddyleague_euro_2021.models.Game;
import io.krippakrull.github.buddyleague_euro_2021.repositories.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Game> list() {
        return gameRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Game get (@PathVariable Long id) {
        return gameRepository.getOne(id);
    }

    @PostMapping
    public Game create(@RequestBody final Game game) {
        return gameRepository.saveAndFlush(game);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //also need to check for children records before delete
        //homework?
        gameRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Game update(@PathVariable Long id, @RequestBody Game game) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need the changes
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Game existingGame = gameRepository.getOne(id);
        BeanUtils.copyProperties(game, existingGame, "gameId");
        return gameRepository.saveAndFlush(existingGame);
    }
}
