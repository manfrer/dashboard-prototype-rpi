package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.History;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoryRepository extends MongoRepository<History,String> {
}
