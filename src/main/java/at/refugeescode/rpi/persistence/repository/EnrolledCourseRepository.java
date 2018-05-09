package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.EnrolledCourse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnrolledCourseRepository extends MongoRepository<EnrolledCourse, String> {
    boolean existsByCourseIdAndUserId(String courseId, String userId);
}
