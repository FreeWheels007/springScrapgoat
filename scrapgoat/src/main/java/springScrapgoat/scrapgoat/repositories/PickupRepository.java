package springScrapgoat.scrapgoat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springScrapgoat.scrapgoat.models.Pickup;

@Repository
public interface PickupRepository extends JpaRepository<Pickup, Long> {
}
