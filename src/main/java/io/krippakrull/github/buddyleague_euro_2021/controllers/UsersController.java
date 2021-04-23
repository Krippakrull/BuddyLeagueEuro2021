package io.krippakrull.github.buddyleague_euro_2021.controllers;

import io.krippakrull.github.buddyleague_euro_2021.models.User;
import io.krippakrull.github.buddyleague_euro_2021.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO: Fix SonarLint problem with demanding a DTO for user
@RestController
@RequestMapping("/api/v1/speakers")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public User get (@PathVariable Long id) {
        return userRepository.getOne(id);
    }

    @PostMapping
    public User create(@RequestBody final User user) {
        return userRepository.saveAndFlush(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //also need to check for children records before delete
        //homework?
        userRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need the changes
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        User existingUser = userRepository.getOne(id);
        BeanUtils.copyProperties(user, existingUser, "speaker_id");
        return userRepository.saveAndFlush(existingUser);
    }
}
