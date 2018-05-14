package at.refugeescode.rpi.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/simulator")
public class MoodleSimulatorEndpoint {
    @RequestMapping(params = {"userName", "firstName", "lastName", "email"}, method = GET)
    String getCourseStatus(@RequestParam("userName") String userName,
                           @RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("email") String email) {
        System.out.println("\ndata:\n" + userName + "\n" + email + "\n" + firstName + "\n" + lastName);
        return "12345";
    }
}