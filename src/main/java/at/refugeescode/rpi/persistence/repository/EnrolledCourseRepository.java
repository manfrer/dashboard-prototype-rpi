package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.EnrolledCourse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EnrolledCourseRepository extends MongoRepository<EnrolledCourse, String> {
    boolean existsByCourseIdAndUserId(String courseId, String userId);

    List<EnrolledCourse> findAllByUserId(String userId);
}
