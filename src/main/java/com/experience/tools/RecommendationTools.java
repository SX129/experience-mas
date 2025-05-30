package com.experience.tools;

import com.google.adk.tools.Annotations.Schema;

import javax.annotation.Nullable;
import java.util.*;

public class RecommendationTools {
    public static Map<String, Object> recommendExperiences(
            @Schema(description = "User's preferred category (e.g., fitness, art, social)") String category,
            @Schema(description = "Urgency level: 'low', 'moderate', or 'high' based on credit expiration") String urgency,
            @Schema(description = "Whether the user tends to cancel frequently") boolean oftenCancels,
            @Schema(description = "Optional weather forecast (e.g., sunny, rainy, cold)") @Nullable String weather) {
        List<String> recommendations = new ArrayList<>();
        System.out.println("[DEBUG] RecommendationTools.recommendExperiences() called");

        if (urgency.equalsIgnoreCase("high")) {
            recommendations.add("Try a last-minute booking in your category to avoid credit expiration.");
        }

        if (category.equalsIgnoreCase("fitness")) {
            if (weather != null && weather.equalsIgnoreCase("sunny")) {
                recommendations.add("Join an outdoor bootcamp or yoga class in the park.");
            } else {
                recommendations.add("Book a HIIT or spin session at a nearby gym.");
            }
        } else if (category.equalsIgnoreCase("art")) {
            recommendations.add("Explore a local pottery class or gallery tour.");
        } else if (category.equalsIgnoreCase("social")) {
            recommendations.add("Attend a curated group event like a wine tasting or improv night.");
        }

        if (oftenCancels) {
            recommendations.add("Pick flexible bookings with free cancellation.");
        }

        return Map.of("recommendations", recommendations);
    }
}
