package az.edu.turing.managementapp.service;

import az.edu.turing.managementapp.domain.entity.User;
import az.edu.turing.managementapp.model.UserDto;
import az.edu.turing.managementapp.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .age(userDto.getAge())
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .profilePhoto(userDto.getProfilePhoto())
                .build();
        userRepository.save(user);
    }

    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUser() {
        userRepository.deleteAll();
    }

    public User updateUser(Long id, User user) {
        Optional<User> foundedUser = userRepository.findById(id);
        if (foundedUser.isPresent()) {
            User updatedUser = foundedUser.get();

            updatedUser.setUsername(user.getUsername());
            updatedUser.setAge(user.getAge());
            updatedUser.setCreated(LocalDateTime.now());
            updatedUser.setUpdated(LocalDateTime.now());
            updatedUser.setProfilePhoto(user.getProfilePhoto());
            userRepository.save(updatedUser);
            return updatedUser;
        }
        return null;
    }

    public long countUsers() {
        return userRepository.count();
    }

}
