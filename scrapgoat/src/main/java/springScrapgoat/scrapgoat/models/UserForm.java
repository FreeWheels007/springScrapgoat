package springScrapgoat.scrapgoat.models;

import java.util.Set;

public class UserForm {

    private String name;
    private String phone;
    private String cell;
    private Set<Location> locations;

    public UserForm() {
    }

    public UserForm(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
        this.cell = user.getCell();
        this.locations = user.getLocations();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Location> getLocations() {
        return locations;
    }

    public void addLocations(Location location) {
        this.locations.add(location);
    }
}
