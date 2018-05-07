package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.Course;
import at.refugeescode.rpi.persistence.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CourseRepository extends MongoRepository<Course, String> {
    Optional<Course> findBymoodleCourseId(String moodleCourseId);
}
