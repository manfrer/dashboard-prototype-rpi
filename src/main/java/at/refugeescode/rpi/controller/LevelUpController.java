package at.refugeescode.rpi.controller;

import at.refugeescode.rpi.persistence.model.User;
import at.refugeescode.rpi.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LevelUpController {
    private UserRepository userRepository;

    //@Value("${levelthreshold}")
    private Integer levelThreshold=10;

    //@Value("${gainedpoints}")
    private Integer gainedPoints=15;

    public LevelUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void earnXp(String userId) {
        User user = userRepository.findById(userId).get();

        Integer newUserXp = gainedPoints + user.getXp();
        Integer newUserLevel = newUserXp / levelThreshold;

        user.setXp(newUserXp);
        user.setLevel(newUserLevel);

        userRepository.save(user);
    }
}
