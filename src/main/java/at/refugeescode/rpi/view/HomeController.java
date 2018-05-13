package at.refugeescode.rpi.view;

import at.refugeescode.rpi.controller.CourseController;
import at.refugeescode.rpi.controller.MoodleController;
import at.refugeescode.rpi.controller.UserController;
import at.refugeescode.rpi.persistence.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private MoodleController moodleController;
    private UserController userController;
    private CourseController courseController;

    public HomeController(MoodleController moodleController, UserController userController, CourseController courseController) {
        this.moodleController = moodleController;
        this.userController = userController;
        this.courseController = courseController;
    }

    @ModelAttribute("user")
    User user(Principal principal) {
        return userController.getUser(principal.getName());
    }

    @ModelAttribute("enrolledcourses")
    List<String> getEnrolledCourse(Principal principal) {
        return courseController.getEnrolledCourseName(principal.getName());
    }

    @ModelAttribute("finishedcourses")
    List<String> getFinishedCourse(Principal principal) {
        return courseController.getFinishedCourseName(principal.getName());
    }


    @PostMapping("/")
    String createMoodleAcouunt(Principal principal) {
        System.out.println(principal);
        moodleController.createNewAccount(principal.getName());
        return "redirect:/?addednew";
    }

    @GetMapping
    String page() {
        return "_home";
    }
}