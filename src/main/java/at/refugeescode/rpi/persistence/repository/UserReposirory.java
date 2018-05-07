package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserReposirory extends MongoRepository<User, String>{
    Optional<User> findBymoodleId(String moodleId);
}
