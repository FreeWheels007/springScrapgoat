package springScrapgoat.scrapgoat.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springScrapgoat.scrapgoat.models.Pickup;
import springScrapgoat.scrapgoat.models.PickupFormGuest;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        // Guest user
        if (principal == null) {
            model.addAttribute("pickup", new PickupFormGuest());
        }
        return "index.html";
    }

    @PostMapping("/")
    public String newPickupPost(Model model, @ModelAttribute PickupFormGuest pickupFormGuest,
                                @AuthenticationPrincipal OidcUser principal) {
        // Guest user
        if (principal == null) {
            model.addAttribute("pickup", pickupFormGuest);
            System.out.println(pickupFormGuest);
        }
        return "index.html";
    }
}
