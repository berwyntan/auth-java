package dev.berwyn.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Optional<User>> login(@RequestBody Map<String, String> payload) {

        String userName = payload.get("userName");
        String password = payload.get("password");

        Optional<User> userExists = userService.verifyUser(userName);

//        user exists
        if (!userExists.isEmpty()) {

            String dbPassword = userExists.get().GetPassword();
//            compare passwords
            if (dbPassword.equals(password)) {
                return new ResponseEntity<Optional<User>>(userExists, HttpStatus.OK);
            } else {
                return new ResponseEntity<Optional<User>>(Optional.empty(), HttpStatus.FORBIDDEN);
            }
        }
        return new ResponseEntity<Optional<User>>(Optional.empty(), HttpStatus.NOT_FOUND);
    }
}
