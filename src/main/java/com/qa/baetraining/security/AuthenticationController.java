package com.qa.baetraining.security;

import com.qa.baetraining.domain.UserInformationSchema;
import com.qa.baetraining.repo.UserFriendRepo;
import com.qa.baetraining.repo.UserPostsRepo;
import com.qa.baetraining.repo.UserRepo;
// import com.example.api.model.User;
// import com.example.api.repository.UserRepository;
import com.qa.baetraining.service.JwtUserDetailsService;
// import com.qa.baetraining.security.JwtTokenUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    protected final Log logger = LogFactory.getLog(getClass());

    final UserRepo userRepository;
    final UserPostsRepo userPostsRepo;
    final UserFriendRepo userFriendRepo;
    final AuthenticationManager authenticationManager;
    final JwtUserDetailsService userDetailsService;
    final JwtTokenUtil jwtTokenUtil;

    public AuthenticationController(UserRepo userRepository, UserPostsRepo userPostsRepo, UserFriendRepo userFriendRepo, AuthenticationManager authenticationManager,
                                    JwtUserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.userPostsRepo = userPostsRepo;
        this.userFriendRepo = userFriendRepo;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    // @PostMapping("/login")
    // public ResponseEntity<?> loginUser(@RequestParam("user_name") String username,
    //                                    @RequestParam("password") String password) {
    //     Map<String, Object> responseMap = new HashMap<>();
    //     try {
    //         Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username
    //                 , password));
    //         if (auth.isAuthenticated()) {
    //             logger.info("Logged In");
    //             UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    //             String token = jwtTokenUtil.generateToken(userDetails);
    //             responseMap.put("error", false);
    //             responseMap.put("message", "Logged In");
    //             responseMap.put("token", token);
    //             return ResponseEntity.ok(responseMap);
    //         } else {
    //             responseMap.put("error", true);
    //             responseMap.put("message", "Invalid Credentials");
    //             return ResponseEntity.status(401).body(responseMap);
    //         }
    //     } catch (DisabledException e) {
    //         e.printStackTrace();
    //         responseMap.put("error", true);
    //         responseMap.put("message", "User is disabled");
    //         return ResponseEntity.status(500).body(responseMap);
    //     } catch (BadCredentialsException e) {
    //         responseMap.put("error", true);
    //         responseMap.put("message", "Invalid Credentials");
    //         return ResponseEntity.status(401).body(responseMap);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         responseMap.put("error", true);
    //         responseMap.put("message", "Something went wrong");
    //         return ResponseEntity.status(500).body(responseMap);
    //     }
    // }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestParam("first_name") String firstName,
                                      @RequestParam("last_name") String lastName,
                                      @RequestParam("user_name") String userName, @RequestParam("email") String email
            , @RequestParam("password") String password, @RequestParam("role") String role ){
        Map<String, Object> responseMap = new HashMap<>();
        UserInformationSchema user = new UserInformationSchema();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setUserName(userName);
        user.setRole(role);
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        String token = jwtTokenUtil.generateToken(userDetails);
        userRepository.save(user);
        responseMap.put("error", false);
        responseMap.put("username", userName);
        responseMap.put("message", "Account created successfully");
        responseMap.put("token", token);
        return ResponseEntity.ok(responseMap);
    }
}