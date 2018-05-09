package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>{

    Optional<User> findByMoodleId(String moodleId);

    Optional<User> findByUsername(String username);
}
