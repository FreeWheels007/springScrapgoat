package springScrapgoat.scrapgoat.models;

import java.util.*;

public class PickupForm {

    private String name;
    private String email;
    private String location;
    private String phone;
    private String cell;
    private String details;
    private List<Location> locations = new ArrayList<>();

    public PickupForm() {
    }

    public PickupForm(User user) {
        name = user.getName();
        email = user.getEmail();
        phone = user.getPhone();
        cell = user.getCell();
        locations = new ArrayList<>(user.getLocations());

        Collections.sort(locations, (l1, l2) -> l1.getAddress().compareTo(l2.getAddress()));
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

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Location> getLocations() {
        return locations;
    }

    @Override
    public String toString() {
        return "Pickup{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", cell=" + cell + '\'' +
                ", details=" + details + '\'' +
                '}';
    }
}
