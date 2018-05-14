package at.refugeescode.rpi.controller;

import at.refugeescode.rpi.persistence.model.EnrolledCourse;
import at.refugeescode.rpi.persistence.model.FinishedCourse;
import at.refugeescode.rpi.persistence.model.History;
import at.refugeescode.rpi.persistence.repository.CourseRepository;
import at.refugeescode.rpi.persistence.repository.EnrolledCourseRepository;
import at.refugeescode.rpi.persistence.repository.FinishedCourseRepository;
import at.refugeescode.rpi.persistence.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CourseController {

    private EnrolledCourseRepository enrolledRepo;
    private FinishedCourseRepository finishedRepo;
    private CourseRepository courseRepo;
    private UserCourseValidator validator;
    private LevelUpController levelUpController;
private HistoryRepository historyRepo;

    public CourseController(EnrolledCourseRepository enrolledRepo,
                            FinishedCourseRepository finishedRepo,
                            CourseRepository courseRepo,
                            UserCourseValidator validator,
                            LevelUpController levelUpController,
                            HistoryRepository historyRepo) {
        this.enrolledRepo = enrolledRepo;
        this.finishedRepo = finishedRepo;
        this.courseRepo = courseRepo;
        this.validator = validator;
        this.levelUpController = levelUpController;
        this.historyRepo = historyRepo;
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

        saveToEnrolledCourse(userId, courseId);

        saveToHistory(userId, courseId, "enrolled");

        return "Success.";
    }

    private void saveToEnrolledCourse(String userId, String courseId) {
        enrolledRepo.save(new EnrolledCourse(courseId, userId));
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

        saveToFinishedCourse(userId, courseId);

        levelUpController.earnXp(userId);

        saveToHistory(userId, courseId, "finished");

        return "Success.";
    }

    private void saveToFinishedCourse(String userId, String courseId) {
        finishedRepo.save(new FinishedCourse(courseId, userId));
    }

    private void saveToHistory(String userId, String courseId, String enrolled) {
        historyRepo.save(new History(courseId, userId, enrolled));
    }

    public List<String> getEnrolledCourseName(String username) {
        String userId = validator.getUserIdByUsername(username);
        return getEnrolledCoursesName(userId);
    }

    public List<String> getFinishedCourseName(String username) {
        String userId = validator.getUserIdByUsername(username);
        return getFinishedCoursesName(userId);
    }

    private List<String> getEnrolledCoursesName(String userId) {
        List<EnrolledCourse> enrolledCourses = enrolledRepo.findAllByUserId(userId);
        return getCoursesName(enrolledCourses);
    }

    private List<String> getFinishedCoursesName(String userId) {
        List<EnrolledCourse> finishedCourses = finishedRepo.findAllByUserId(userId);
        return getCoursesName(finishedCourses);
    }

    private List<String> getCoursesName(List<EnrolledCourse> courses) {
        if (courses.isEmpty())
            return new ArrayList<>();
        return Stream.of(courses)
                .map(course -> course.get(0).getCourseId())
                .map(courseId -> courseRepo.findById(courseId))
                .filter(Optional::isPresent)
                .map(course -> course.get().getName())
                .collect(Collectors.toList());
    }

}
