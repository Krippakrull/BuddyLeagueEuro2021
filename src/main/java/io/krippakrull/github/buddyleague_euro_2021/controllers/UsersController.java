package io.krippakrull.github.buddyleague_euro_2021.controllers;

import io.krippakrull.github.buddyleague_euro_2021.models.User;
import io.krippakrull.github.buddyleague_euro_2021.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
//TODO: Fix SonarLint problem with demanding a DTO for user
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public User get (@PathVariable Long id) {
        return userRepository.getOne(id);
    }

    @PostMapping
    public User create(@RequestBody @Valid final User user) {
        return userRepository.saveAndFlush(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //also need to check for children records before delete
        //homework?
        userRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody @Valid User user) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need the changes
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        //now returns 400 due to Validation annotation, look into custom error messages?
        User existingUser = userRepository.getOne(id);
        BeanUtils.copyProperties(user, existingUser, "userId");
        return userRepository.saveAndFlush(existingUser);
    }
}
