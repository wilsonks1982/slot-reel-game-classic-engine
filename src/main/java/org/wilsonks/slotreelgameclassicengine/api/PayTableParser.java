package org.wilsonks.slotreelgameclassicengine.api;

import java.util.regex.Pattern;

public class PayTableParser {
    public static Pattern convertToRegex(String rawPattern) {
        String clean = rawPattern.replace("[", "").replace("]", "");

        String[] parts = clean.split("\\|");
        StringBuilder regexBuilder = new StringBuilder("^"); // Start of the regex pattern

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if ("**".equals(part)) {
                regexBuilder.append("[A-Z0-9]{2}"); // Wildcard for any two characters (A-Z, 0-9)
            } else {
                regexBuilder.append(Pattern.quote(part));
            }

            if (i < parts.length - 1) {
                regexBuilder.append("-"); // Add the hyphen between parts, except after the last part
            }
        }
        regexBuilder.append("$");  // Ensure the regex matches the entire string
        return Pattern.compile(regexBuilder.toString());
    }
}

