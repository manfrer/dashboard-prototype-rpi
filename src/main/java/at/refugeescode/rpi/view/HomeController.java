package at.refugeescode.rpi.view;

import at.refugeescode.rpi.controller.MoodleController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {
    private MoodleController moodleController;

    public HomeController(MoodleController moodleController) {
        this.moodleController = moodleController;
    }

    @PostMapping("/")
    String createMoodleAcouunt(Principal principal) {
        System.out.println(principal);
        moodleController.createNewAccount(principal.getName());
        return "redirect:/?addednew";
    }

    @GetMapping
    String page() {
        return "home";
    }
}