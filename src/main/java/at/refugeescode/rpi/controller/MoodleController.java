package at.refugeescode.rpi.controller;

import at.refugeescode.rpi.persistence.model.User;
import at.refugeescode.rpi.persistence.repository.UserReposirory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class MoodleController {
    private RestTemplate rest;
    private UserReposirory userRepo;
    //TODO: Read userId from Session.
    private String userId;

    @Value("${moodle.url}")
    private String moodleUrl;

    public MoodleController(RestTemplate rest, UserReposirory userRepo) {
        this.rest = rest;
        this.userRepo = userRepo;
    }

    public void createNewAccount() {
        StringBuilder queryBuilder = builderQuery();
        if (queryBuilder == null) return;

        String url = moodleUrl + queryBuilder;
        String moodleId = rest.getForObject(url, String.class);

        addMoodleIdToTheUser(moodleId);
    }

    private void addMoodleIdToTheUser(String moodleId) {
        User user = userRepo.findById(userId).get();
        user.setMoodleId(moodleId);
        userRepo.save(user);
    }

    private StringBuilder builderQuery() {
        Optional<User> user = userRepo.findById(userId);
        if (!user.isPresent()){
            return null;
        }
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("?userName=");
        queryBuilder.append(user.get().getUserName());
        queryBuilder.append("&firstName=");
        queryBuilder.append(user.get().getFirstName());
        queryBuilder.append("&lastName=");
        queryBuilder.append(user.get().getLastName());
        queryBuilder.append("&email=");
        queryBuilder.append(user.get().getEmail());
        return queryBuilder;
    }
}
