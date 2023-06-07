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
        // Logic for login
        // You can implement authentication and authorization logic here
        // For example, you can check if the provided username and password match the user's credentials in the database
        if (user.getUsername().equals(this.username) && user.getPassword().equals(this.password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

    public void logout(User user) {
        // Logic for logout
        // You can implement session management logic here
        // For example, you can invalidate the user's session or clear any stored authentication tokens
        System.out.println("Logged out");
    }

    public void changePass(User user) {
        // Logic for changing password
        // You can implement password change logic here
        // For example, you can update the user's password in the database
        this.password = user.getPassword();
        System.out.println("Password changed successfully");
    }

    public void viewPages(User user) {
        // Logic for viewing pages
        // You can implement page access control logic based on user roles or permissions here
        // For example, you can check if the user has the required role or permission to access a specific page
        if (user.getRole().equals(USER)) {
            System.out.println("Viewing all pages");
        } else {
            System.out.println("Viewing limited pages");
        }
    }

}