package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserReposirory extends MongoRepository<User, String>{
}
