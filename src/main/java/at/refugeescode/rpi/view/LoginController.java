package at.refugeescode.rpi.view;

import at.refugeescode.rpi.controller.UserController;
import at.refugeescode.rpi.persistence.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private UserController userController;

    public LoginController(UserController userController) {
        this.userController = userController;
    }

    @ModelAttribute("newUser")
    User user() {
        return new User();
    }

    @PostMapping("/register")
    String newUser(User user) {
        System.out.println(user);
        User savedNewUser = userController.addNew(user);
        System.out.println(savedNewUser);
        return "redirect:/login";
    }

    @GetMapping
    String page() {
        return "login";
    }
}