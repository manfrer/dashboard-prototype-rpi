package at.refugeescode.rpi.controller;

import at.refugeescode.rpi.persistence.model.User;
import at.refugeescode.rpi.persistence.repository.UserReposirory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserController {
    private UserReposirory userRepo;
    private PasswordEncoder encoder;

    public UserController(UserReposirory userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public User addNew(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public void addMoodleNew() {

    }
}
