package az.edu.turing.managementapp.controller;

import az.edu.turing.managementapp.domain.entity.User;
import az.edu.turing.managementapp.model.UserDto;
import az.edu.turing.managementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public void createProfile(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/all")
    public Iterable<User> getAllProfile() {
       return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getProfileById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProfileById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllProfile() {
        userService.deleteAllUser();
    }

    @PutMapping("/update/{id}")
    public User updateProfile(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // getCount

}
