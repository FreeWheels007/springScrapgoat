package springScrapgoat.scrapgoat.models;

import java.util.HashSet;
import java.util.Set;

public class PickupFormGuest {

    private String name;
    private String email;
    private String location;
    private String phone;
    private Set<Location> locations = new HashSet<>();

    public PickupFormGuest() {
    }

    public PickupFormGuest(User user) {
        name = user.getName();
        email = user.getEmail();
        phone = user.getPhone();
        locations = user.getLocations();

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Set<Location> getLocations() {
        return locations;
    }

    @Override
    public String toString() {
        return "Pickup{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
