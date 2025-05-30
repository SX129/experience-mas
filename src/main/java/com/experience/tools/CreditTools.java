package com.experience.tools;

import com.google.adk.tools.Annotations.Schema;
import java.util.Map;
public class CreditTools {
    public static Map<String, String> optimizeCredits(
            @Schema(description = "User ID") String userId,
            @Schema(description = "Total credits available") int totalCredits,
            @Schema(description = "Rollover credits") int rolloverCredits,
            @Schema(description = "Days until credits expire") int expirationDays
    ) {
        if (expirationDays < 5) {
            return Map.of("action", "User has credits about to expire. Recommend time-sensitive experience.");
        } else if (rolloverCredits > 10) {
            return Map.of("action", "Encourage usage of rollover credits via promotional offer.");
        } else {
            return Map.of("action", "User credit profile is healthy.");
        }
    }
}
