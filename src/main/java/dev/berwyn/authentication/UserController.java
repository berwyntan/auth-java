package dev.berwyn.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = {"https://auth-java-client.vercel.app", "http://127.0.0.1:5173"})
@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> login(@RequestBody Map<String, String> payload) {

        String userName = payload.get("userName");
        String password = payload.get("password");

        Optional<User> userExists = userService.verifyUser(userName);

        User userInfo = new User();

//        if user exists
        if (!userExists.isEmpty()) {

            String dbPassword = userExists.get().GetPassword();
//            compare passwords
            if (dbPassword.equals(password)) {
                userInfo.setUserName(userExists.get().getUserName());
                userInfo.setUserFullName(userExists.get().getUserFullName());
                userInfo.setRole(userExists.get().getRole());
                userInfo.setId(userExists.get().getId());
                return new ResponseEntity<User>(userInfo, HttpStatus.OK);
            } else {
                userInfo.setUserName(userExists.get().getUserName());
                return new ResponseEntity<User>(userInfo, HttpStatus.FORBIDDEN);
            }
        }
        return new ResponseEntity<User>(userInfo, HttpStatus.NOT_FOUND);
    }
}
