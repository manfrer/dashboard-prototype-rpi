package at.refugeescode.rpi.persistence.repository;

import at.refugeescode.rpi.persistence.model.EnrolledCourse;
import at.refugeescode.rpi.persistence.model.FinishedCourse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FinishedCourseRepository extends MongoRepository<FinishedCourse,String>{

    boolean existsByCourseIdAndUserId(String courseId, String userId);

    List<EnrolledCourse> findAllByUserId(String userId);
}
