package com.commandos.security;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Carica la configurazione da file YAML (users, security, logging...).
 */
public class Config {
    private static Config instance;
    private List<Map<String, Object>> users;
    private Map<String, Object> security;
    private Map<String, Object> logging;

    private Config() {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("config-example.yml")) {
            if (in != null) {
                Yaml yaml = new Yaml();
                Map<String, Object> root = yaml.load(in);
                users = (List<Map<String, Object>>) root.get("users");
                security = (Map<String, Object>) root.get("security");
                logging = (Map<String, Object>) root.get("logging");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config-example.yml", e);
        }
    }

    public static Config getInstance() {
        if (instance == null) instance = new Config();
        return instance;
    }

    public List<Map<String, Object>> getUsers() { return users; }
    public Map<String, Object> getSecurity() { return security; }
    public Map<String, Object> getLogging() { return logging; }
}
