package dev.berwyn.authentication;

import netscape.javascript.JSObject;
import org.bson.json.JsonObject;
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
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Optional<User>> login(@RequestBody Map<String, String> payload) {

        String userName = payload.get("userName");
        String password = payload.get("password");
        Optional<User> userExists = userService.verifyUser(userName);
        Optional<User> passwordExists = userService.verifyPassword(password);
        System.out.println(passwordExists);
//        if (!userExists.isEmpty()) {
//            System.out.println(userExists.equals(passwordExists));
//        }


        return new ResponseEntity<Optional<User>>(userExists, HttpStatus.OK);
    }
}
