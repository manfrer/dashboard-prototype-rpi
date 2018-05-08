package at.refugeescode.rpi.view;

import at.refugeescode.rpi.controller.MoodleController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private MoodleController moodleController;

    public HomeController(MoodleController moodleController) {
        this.moodleController = moodleController;
    }

    @PostMapping("/")
    String createMoodleAcouunt() {
        moodleController.createNewAccount();
        return "redirect:/";
    }

    @GetMapping
    String page() {
        return "home";
    }
}