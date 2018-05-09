package at.refugeescode.rpi.controller;

import at.refugeescode.rpi.persistence.model.User;
import at.refugeescode.rpi.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MoodleController {
    private RestTemplate rest;
    private UserRepository userRepo;

    @Value("${moodle.url}")
    private String moodleUrl;

    public MoodleController(RestTemplate rest, UserRepository userRepo) {
        this.rest = rest;
        this.userRepo = userRepo;
    }

    //@Secured("hasAuthority('USER')")
    public void createNewAccount(String username) {

        User user = userRepo.findByUsername(username).get();

        String query = buildQuery(user);

        String url = moodleUrl + query;

        String moodleId = rest.getForObject(url, String.class);

        setMoodleId(user, moodleId);
    }

    private void setMoodleId(User user, String moodleId) {
        user.setMoodleId(moodleId);
        User savedUser = userRepo.save(user);
        System.out.println(savedUser);
    }

    private String buildQuery(User user)  {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("?userName=");
        queryBuilder.append(user.getUsername());
        queryBuilder.append("&firstName=");
        queryBuilder.append(user.getFirstName());
        queryBuilder.append("&lastName=");
        queryBuilder.append(user.getLastName());
        queryBuilder.append("&email=");
        queryBuilder.append(user.getEmail());
        return queryBuilder.toString();
    }
}
