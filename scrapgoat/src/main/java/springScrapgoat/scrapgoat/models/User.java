package springScrapgoat.scrapgoat.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;
    private String email;
    private String phone;
    private String cell;
    private LocalDate accountCreationDate;
    private Boolean isBlocked;
    private Set<String> locations = new HashSet<>();
    private Set<Pickup> pickupPostings = new HashSet<>();

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

    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDate accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Set<String> getLocations() {
        return locations;
    }

    public void addLocation(String location) {
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
                ", accountCreationDate=" + accountCreationDate +
                ", isBlocked=" + isBlocked +
                ", # locations=" + locations.size() +
                ", # postings=" + pickupPostings.size() +
                '}';
    }
}
