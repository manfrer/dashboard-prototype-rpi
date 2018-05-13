package at.refugeescode.rpi.controller;

import at.refugeescode.rpi.persistence.repository.CourseRepository;
import at.refugeescode.rpi.persistence.repository.EnrolledCourseRepository;
import at.refugeescode.rpi.persistence.repository.FinishedCourseRepository;
import at.refugeescode.rpi.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCourseValidator {
    private CourseRepository courseRepo;
    private UserRepository userRepo;
    private EnrolledCourseRepository enrolledRepo;
    private FinishedCourseRepository finishedRepo;

    public UserCourseValidator(CourseRepository courseRepo, UserRepository userRepo, EnrolledCourseRepository enrolledRepo, FinishedCourseRepository finishedRepo) {
        this.courseRepo = courseRepo;
        this.userRepo = userRepo;
        this.enrolledRepo = enrolledRepo;
        this.finishedRepo = finishedRepo;
    }

    public Boolean isMoodleInfoExist(String moodleId, String moodleCourseId) {
        if (!userRepo.findByMoodleId(moodleId).isPresent()) {
            System.out.println("User does not Exist");
            return false;
        }
        if (!courseRepo.findBymoodleCourseId(moodleCourseId).isPresent()) {
            System.out.println("Course does not Exist");
            return false;
        }
        return true;
    }

    public String getUserId(String moodleId) {
        return userRepo.findByMoodleId(moodleId).get().getId();
    }

    public String getCourseId(String moodleCourseId) {
        return courseRepo.findBymoodleCourseId(moodleCourseId).get().getId();
    }

    public boolean isEnrolled(String courseId, String userId) {
        return enrolledRepo.existsByCourseIdAndUserId(courseId, userId);
    }

    public boolean isFinished(String courseId, String userId) {
        return finishedRepo.existsByCourseIdAndUserId(courseId, userId);
    }

    public String getUserIdByUsername(String username) {
        return userRepo.findByUsername(username).get().getId();
    }
}
