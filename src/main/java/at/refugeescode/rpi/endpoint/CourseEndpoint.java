package at.refugeescode.rpi.endpoint;

import at.refugeescode.rpi.controller.CourseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class CourseEndpoint {
    private CourseController courseController;

    public CourseEndpoint(CourseController courseController) {
        this.courseController = courseController;
    }

    @RequestMapping(params = {"course_status", "course_id", "moodle_id"}, method = GET)
    void getCourseStatus(@RequestParam("course_status") String courseStatus,
                         @RequestParam("course_id") String moodleCourseId,
                         @RequestParam("moodle_id") String moodleId) {
        if (courseStatus.contains("enrolled")) {
            courseController.enrolled(moodleCourseId, moodleId);
        }
        if (courseStatus.contains("finished")) {
            courseController.finished(moodleCourseId, moodleId);
        }

    }

    @GetMapping
    void wrongRequest() {
        System.out.println("\n ---! Request is wrong !");
    }
}
