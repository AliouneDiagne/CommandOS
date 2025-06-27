package com.commandos.infra;

import java.util.regex.Pattern;

/**
 * Filtra input CLI per evitare injection e caratteri strani.
 */
public final class InputSanitizer {
    private static final Pattern SAFE_PATTERN = Pattern.compile("[a-zA-Z0-9_:\\-./|\\s]+");

    private InputSanitizer() {}

    public static String clean(String input) {
        if (input == null) return "";
        String trimmed = input.strip();
        if (SAFE_PATTERN.matcher(trimmed).matches()) return trimmed;
        // Rimuove caratteri non whitelisted
        return trimmed.replaceAll("[^a-zA-Z0-9_:\\-./|\\s]", "");
    }
}
