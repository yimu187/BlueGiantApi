package com.bluegiant.task.dto;

import java.util.ArrayList;
import java.util.List;

public class JwtResponseDto {
    private String token;

    private String username;

    private String email;

    private Long id;

    private List<String> roles = new ArrayList<>();

    public JwtResponseDto(String token, Long id,  String username, String email, List<String> roles) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.id = id;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
