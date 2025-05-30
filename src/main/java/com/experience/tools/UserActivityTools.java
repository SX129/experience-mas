package com.experience.tools;

import java.util.Map;
import com.google.adk.tools.Annotations.Schema;

public class UserActivityTools {
    public static Map<String, Object> analyzeUserActivity(
            @Schema(description = "The unique user ID") String userId,
            @Schema(description = "How many credits the user used last month") int creditsUsed,
            @Schema(description = "Number of activities the user booked") int activitiesBooked,
            @Schema(description = "Whether they often cancel") boolean oftenCancels) {

        String result;

        if (creditsUsed < 3 && !oftenCancels) {
            result = "User is underutilizing subscription. Recommend nudging them with a new class.";
        } else if (oftenCancels) {
            result = "User often cancels classes. Consider surveying for feedback.";
        } else {
            result = "User is actively using the platform. Recommend similar experiences.";
        }

        return Map.of("user_activity_insight", result);
    }
}
