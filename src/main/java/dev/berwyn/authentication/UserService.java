package dev.berwyn.authentication;

import static com.mongodb.client.model.Filters.eq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<User> verifyUser(String userName) {
        return userRepository.findUserByUserName(userName);
    }
}
