package springScrapgoat.scrapgoat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springScrapgoat.scrapgoat.models.PickupForm;
import springScrapgoat.scrapgoat.models.User;
import springScrapgoat.scrapgoat.services.PickupService;
import springScrapgoat.scrapgoat.services.UserService;

@Controller
public class HomeController {

    private final UserService userService;
    private final PickupService pickupService;

    @Autowired
    public HomeController(UserService userService, PickupService pickupService) {
        this.userService = userService;
        this.pickupService = pickupService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        // Guest user
        if (principal == null) {
            model.addAttribute("pickup", new PickupForm());
        } else {
            User user = userService.getUserByEmail(principal.getEmail());
            PickupForm pickupForm;
            if (user == null){
                pickupForm = new PickupForm();
            } else {
                pickupForm = new PickupForm(user);
            }

            model.addAttribute("pickup", pickupForm);
        }
        return "index.html";
    }

    @PostMapping("/pickup")
    public String newPickupPost(Model model, @ModelAttribute PickupForm pickupForm,
                                @AuthenticationPrincipal OidcUser principal) {
        User user = null;
        if (principal != null) {
            user = userService.getUserByEmail(principal.getEmail());
        }

        model.addAttribute("pickup", pickupForm);
        System.out.println(pickupForm);

        pickupService.savePickup(pickupForm, user);

        return "redirect:/";
    }
}
