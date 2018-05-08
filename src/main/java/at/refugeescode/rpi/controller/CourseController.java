package at.refugeescode.rpi.controller;

import at.refugeescode.rpi.persistence.model.EnrolledCourse;
import at.refugeescode.rpi.persistence.model.FinishedCourse;
import at.refugeescode.rpi.persistence.repository.CourseRepository;
import at.refugeescode.rpi.persistence.repository.EnrolledCourseRepository;
import at.refugeescode.rpi.persistence.repository.FinishedCourseRepository;
import at.refugeescode.rpi.persistence.repository.UserReposirory;
import org.springframework.stereotype.Service;

@Service
public class CourseController {
    private CourseRepository courseRepo;
    private UserReposirory userRepo;
    private EnrolledCourseRepository enrolledRepo;
    private FinishedCourseRepository finishedRepo;

    public CourseController(CourseRepository courseRepo, UserReposirory userRepo, EnrolledCourseRepository enrolledRepo, FinishedCourseRepository finishedRepo) {
        this.courseRepo = courseRepo;
        this.userRepo = userRepo;
        this.enrolledRepo = enrolledRepo;
        this.finishedRepo = finishedRepo;
    }

    public void enrolled(String moodleCourseId, String moodleId) {
        if (!userRepo.findBymoodleId(moodleId).isPresent()){
            System.out.println("User does not Exist");
            return;
        }
        if (!courseRepo.findBymoodleCourseId(moodleCourseId).isPresent()){
            System.out.println("Course does not Exist");
            return;
        }

        String userId = userRepo.findBymoodleId(moodleId).get().getId();
        String courseId = courseRepo.findBymoodleCourseId(moodleCourseId).get().getId();
        enrolledRepo.save(new EnrolledCourse(courseId,userId));
    }

    public void finished(String moodleCourseId, String moodleId) {
        if (!userRepo.findBymoodleId(moodleId).isPresent()){
            System.out.println("User does not Exist");
            return;
        }
        if (!courseRepo.findBymoodleCourseId(moodleCourseId).isPresent()){
            System.out.println("Course does not Exist");
            return;
        }

        String userId = userRepo.findBymoodleId(moodleId).get().getId();
        String courseId = courseRepo.findBymoodleCourseId(moodleCourseId).get().getId();
        finishedRepo.save(new FinishedCourse(courseId,userId));
    }
}
