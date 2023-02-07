package com.example.springapp.classes;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class User {
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long user_id;
    private String username;
    private String fullNames;
    private LocalDate dob;
    private String email;
    private String profilePic;



    private String role;
    private boolean isMarried;

    public User(String username, String fullNames, String email, String profilePic, boolean isMarried, LocalDate dob , String role) {
        this.username = username;
        this.fullNames = fullNames;
        this.dob = dob;
        this.email = email;
        this.profilePic = profilePic;
        this.isMarried = isMarried;
        this.role = role;
    }

    public User() {

    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
