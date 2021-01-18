package com.bluegiant.task.controller;

import com.bluegiant.task.dto.LoginRequestDto;
import com.bluegiant.task.dto.SignupRequestDto;
import com.bluegiant.task.service.AuthService;
import com.bluegiant.task.service.impl.UserDetailsImpl;
import com.bluegiant.task.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthService authService;

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
        String jwt = authService.doSignin(loginRequest);

        modelMap.put("success", true);
        modelMap.put("jwt", jwt);

        return modelMap;
    }

    @PostMapping("/signup")
    public ModelMap registerUser(@Valid @RequestBody SignupRequestDto signUpRequest) {
        ModelMap modelMap = new ModelMap();
        String jwt = authService.doSignup(signUpRequest);

        modelMap.put("success", true);
        modelMap.put("message", "Kullanıcı kaydedildi");
        modelMap.put("jwt", jwt);

        return modelMap;
    }


}
