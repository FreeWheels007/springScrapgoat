package springScrapgoat.scrapgoat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springScrapgoat.scrapgoat.models.Location;
import springScrapgoat.scrapgoat.models.User;
import springScrapgoat.scrapgoat.models.UserForm;
import springScrapgoat.scrapgoat.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String user(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal == null) {
            return "redirect:/";
        }
        String email = principal.getEmail();
        System.out.println("auth0 " + email);
        User user = userService.getUserByEmail(email);
        System.out.println(user);
        model.addAttribute("email", email);

        if (user == null) {
            user = new User();
            System.out.println(user);
            userService.updateUser(user, email);
        }

        System.out.println(user);
        model.addAttribute("user", new UserForm(user));

        System.out.println("get user id " + user.getId());

        return "user.html";
    }

    @PostMapping("/user")
    public String updateUserInfo(Model model, @ModelAttribute UserForm userForm,
                                 @AuthenticationPrincipal OidcUser principal, HttpServletRequest request) {
        model.addAttribute("user", userForm);
        String email = principal.getEmail();
        User user = userService.getUserByEmail(email);
        if (request.getParameter("newLocation") != null) {
            String newAddress = request.getParameter("new");

            user.addLocation(new Location(newAddress));
        }
        userService.mergeUserForm_User(userForm, user);

        userService.updateUser(user, principal.getEmail());

        return "redirect:/user";
    }
}
