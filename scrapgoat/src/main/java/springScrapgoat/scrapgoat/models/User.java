package springScrapgoat.scrapgoat.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cell;
    private LocalDate accountUpdatedDate;
    private Boolean isBlocked = Boolean.FALSE;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Location> locations = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Pickup> pickupPostings = new HashSet<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public LocalDate getAccountUpdatedDate() {
        return accountUpdatedDate;
    }

    public void setAccountUpdatedDate(LocalDate accountUpdatedDate) {
        this.accountUpdatedDate = accountUpdatedDate;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        this.locations.add(location);
    }

    public Set<Pickup> getPickupPostings() {
        return pickupPostings;
    }

    public void addPickupPosting(Pickup pickup) {
        this.pickupPostings.add(pickup);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", cell='" + cell + '\'' +
                ", accountUpdatedDate=" + accountUpdatedDate +
                ", isBlocked=" + isBlocked +
                ", # locations=" + locations.size() +
                ", # postings=" + pickupPostings.size() +
                '}';
    }
}
