package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
