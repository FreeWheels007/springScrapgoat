package springScrapgoat.scrapgoat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springScrapgoat.scrapgoat.models.User;
import springScrapgoat.scrapgoat.models.UserForm;
import springScrapgoat.scrapgoat.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        // if there is a user, return it, else return null
        return (user.isPresent() ? user.get() : null);
    }

    public void mergeUserForm_User(UserForm userForm, User user) {
        user.setName(userForm.getName());
        user.setPhone(userForm.getPhone());
        user.setCell(userForm.getCell());
    }

    public void updateUser(User user, String email) {
        user.setAccountUpdatedDate(LocalDate.now());
        user.setEmail(email);
        userRepository.save(user);
    }
}
