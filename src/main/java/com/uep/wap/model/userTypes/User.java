package com.uep.wap.model.userTypes;

import javax.persistence.*;

import static com.uep.wap.model.Role.USER;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void login(User user) {
        if (user.getUsername().equals(this.username) && user.getPassword().equals(this.password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

    public void logout(User user) {
        System.out.println("Logged out");
    }

    public void changePass(User user) {
        this.password = user.getPassword();
        System.out.println("Password changed successfully");
    }

    public void viewPages(User user) {
        if (user.getRole().equals(USER)) {
            System.out.println("Viewing all pages");
        } else {
            System.out.println("Viewing limited pages");
        }
    }
}