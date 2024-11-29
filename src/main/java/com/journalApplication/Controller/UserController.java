package com.journalApplication.Controller;
//import com.journalApplication.ApiResponse.WeatherResponse;
import com.journalApplication.ApiResponse.WeatherResponse;
import com.journalApplication.Entity.UserEntry;
import com.journalApplication.Repository.UserRepository;
import com.journalApplication.Service.UserService;
import com.journalApplication.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    @PostMapping
    public void createuser(@RequestBody UserEntry user){
        userService.saveAdmin(user);
    }

// this method is just for checking the answer

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntry user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserEntry userInDb = userService.findByUserName(userName);
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
        WeatherResponse weatherResponse = weatherService.getWeather("mumbai");
        String greeting = "";
        if (weatherResponse != null) {
            greeting = ", Weather feels like " + weatherResponse.getMain().getFeels_like();
        }
        return new ResponseEntity<>("Hi " + authentication.getName(), HttpStatus.OK);
    }


}
