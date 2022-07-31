package springScrapgoat.scrapgoat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springScrapgoat.scrapgoat.models.Pickup;
import springScrapgoat.scrapgoat.models.PickupForm;
import springScrapgoat.scrapgoat.models.User;
import springScrapgoat.scrapgoat.repositories.PickupRepository;

@Service
public class PickupService {

    private final PickupRepository pickupRepository;

    @Autowired
    public PickupService(PickupRepository pickupRepository) {
        this.pickupRepository = pickupRepository;
    }

    public void savePickup(PickupForm pickupForm, User user) {
        Pickup pickup = new Pickup();
        pickup.setName(pickupForm.getName());
        pickup.setEmail(pickupForm.getEmail());
        pickup.setPhone(pickupForm.getPhone());
        pickup.setCell(pickupForm.getCell());
        pickup.setDetails(pickupForm.getDetails());

        pickup.setLocation(pickupForm.getLocation());
        pickup.setUser(user);

        pickupRepository.save(pickup);
    }
}
