package com.commandos.security;

import java.util.List;
import java.util.Map;

/**
 * Servizio di autenticazione utenti.
 * Verifica username e hash password rispetto alla config.
 */
public class AuthService {
    private final List<Map<String, Object>> users;

    public AuthService() {
        users = Config.getInstance().getUsers();
    }

    public boolean authenticate(String username, String passwordHash) {
        if (users == null) return false;
        for (Map<String, Object> user : users) {
            String u = (String) user.get("username");
            String h = (String) user.get("password_hash");
            if (u.equals(username) && h.equals(passwordHash)) {
                return true;
            }
        }
        return false;
    }

    public boolean userExists(String username) {
        if (users == null) return false;
        for (Map<String, Object> user : users) {
            String u = (String) user.get("username");
            if (u.equals(username)) {
                return true;
            }
        }
        return false;
    }
}
