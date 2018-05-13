package at.refugeescode.rpi.controller;

import at.refugeescode.rpi.persistence.model.User;
import at.refugeescode.rpi.persistence.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserController {
    private UserRepository userRepo;
    private PasswordEncoder encoder;

    public UserController(UserRepository userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public User addNew(User user) {
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            return null;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User getUser(String username) {
        return userRepo.findByUsername(username).get();
    }
}
