package at.refugeescode.rpi.controller;

import at.refugeescode.rpi.persistence.model.EnrolledCourse;
import at.refugeescode.rpi.persistence.model.FinishedCourse;
import at.refugeescode.rpi.persistence.repository.EnrolledCourseRepository;
import at.refugeescode.rpi.persistence.repository.FinishedCourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseController {

    private EnrolledCourseRepository enrolledRepo;
    private FinishedCourseRepository finishedRepo;
    private UserCourseValidator validator;
private LevelUpController levelUpController;

    public CourseController(EnrolledCourseRepository enrolledRepo, FinishedCourseRepository finishedRepo, UserCourseValidator validator, LevelUpController levelUpController) {
        this.enrolledRepo = enrolledRepo;
        this.finishedRepo = finishedRepo;
        this.validator = validator;
        this.levelUpController = levelUpController;
    }

    public String enrolled(String moodleCourseId, String moodleId) {
        if (!validator.isMoodleInfoExist(moodleId, moodleCourseId)) {
            return "Cannot find User Or Course";
        }

        String userId = validator.getUserId(moodleId);
        String courseId = validator.getCourseId(moodleCourseId);

        if (validator.isEnrolled(courseId, userId)) {
            return "User already Enrolled in this Course!";
        }

        enrolledRepo.save(new EnrolledCourse(courseId, userId));

        return "Success.";
    }

    public String finished(String moodleCourseId, String moodleId) {
        if (!validator.isMoodleInfoExist(moodleId, moodleCourseId)) {
            return "Cannot find User Or Course";
        }

        String userId = validator.getUserId(moodleId);
        String courseId = validator.getCourseId(moodleCourseId);

        if (validator.isFinished(courseId, userId)) {
            return "User already Finished this Course!";
        }

        if (!validator.isEnrolled(courseId, userId)) {
            return "User isn't Enrolled in this Course!";
        }


        enrolledRepo.deleteById(userId);

        finishedRepo.save(new FinishedCourse(courseId, userId));

        levelUpController.earnXp(userId);

        return "Success.";
        //TODO: Save in History DB
    }
}
