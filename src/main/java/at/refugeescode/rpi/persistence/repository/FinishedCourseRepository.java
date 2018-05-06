package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.FinishedCourse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FinishedCourseRepository extends MongoRepository<FinishedCourse,String>{
}
