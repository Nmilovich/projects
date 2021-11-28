package com.example.awito.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "User name cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    private boolean active;
    private boolean Banned = false;

    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    private String activationCode;

    //fetch - подгрузка ролей
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public boolean isAdmin() {
        return this.getRoles().contains(Role.ADMIN);
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isBanned() {
        return Banned;
    }

    public void setBanned(boolean banned) {
        Banned = banned;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    //Указывает, истек ли срок действия учетных данных (пароля) пользователя.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Указывает, заблокирован или разблокирован пользователь
    @Override
    public boolean isAccountNonLocked() {
        return !Banned;
    }

    //Указывает, истек ли срок действия учетной записи пользователя.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Указывает, включен или отключен пользователь.
    @Override
    public boolean isEnabled() {
        return isActive();
    }

    //Возвращает полномочия, предоставленные пользователю.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }
}
