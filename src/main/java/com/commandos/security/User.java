package com.commandos.security;

import java.util.Set;

/**
 * Rappresenta un utente di CommandOS (username, hash, ruoli).
 */
public class User {
    private final String username;
    private final String passwordHash;
    private final Set<String> roles;

    public User(String username, String passwordHash, Set<String> roles) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.roles = roles;
    }

    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public Set<String> getRoles() { return roles; }
}
