package com.bluegiant.task.controller;

import com.bluegiant.task.dao.RoleDao;
import com.bluegiant.task.dao.UserDao;
import com.bluegiant.task.dto.JwtResponseDto;
import com.bluegiant.task.dto.LoginRequestDto;
import com.bluegiant.task.dto.MessageResponseDto;
import com.bluegiant.task.dto.SignupRequestDto;
import com.bluegiant.task.model.Role;
import com.bluegiant.task.model.User;
import com.bluegiant.task.service.impl.UserDetailsImpl;
import com.bluegiant.task.type.ERole;
import com.bluegiant.task.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("loginInfo")
    public ModelMap getLoginInfo(){
        ModelMap modelMap = new ModelMap();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean logined = authentication != null && authentication.getPrincipal() != null && (authentication.getPrincipal() instanceof UserDetailsImpl);
        String jwt = null;
        if(logined){
            jwt = jwtUtils.generateJwtToken(authentication);
        }
        modelMap.put("success", true);
        modelMap.put("jwt", jwt);

        return modelMap;
    }

    @PostMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/index.html"; //You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    @PostMapping("/signin")
    public ModelMap authenticateUser(@Valid @RequestBody LoginRequestDto loginRequest) {
        ModelMap modelMap = new ModelMap();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        modelMap.put("success", true);
        modelMap.put("jwt", jwt);

        return modelMap;
    }

    @PostMapping("/signup")
    public ModelMap registerUser(@Valid @RequestBody SignupRequestDto signUpRequest) {
        ModelMap modelMap = new ModelMap();
        if (userDao.existsByUsername(signUpRequest.getUsername())) {
            modelMap.put("success", false);
            modelMap.put("message", "Error: Username is already taken!");
            modelMap.put("jwt", null);
            return modelMap;
        }

        if (userDao.existsByEmail(signUpRequest.getEmail())) {
            modelMap.put("success", false);
            modelMap.put("message", "Error: Email is already in use!");
            modelMap.put("jwt", null);
            return modelMap;
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleDao.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleDao.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleDao.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleDao.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userDao.save(user);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signUpRequest.getUsername(), signUpRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        modelMap.put("success", true);
        modelMap.put("message", "Kullanıcı kaydedildi");
        modelMap.put("jwt", jwt);

        return modelMap;
    }
}
