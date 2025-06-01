package com.experience.agents;

import com.experience.tools.mock.ExperienceMockDataTool;
import com.experience.tools.weather.WeatherTool;
import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.FunctionTool;

public class RecommendationAgent {
    private static final String NAME = "recommendation_agent";

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name(NAME)
                .model("gemini-2.0-flash")
                .description("Recommends personalized experiences for the user.")
                .instruction("""
                            You are a Personalized Experience Recommender.
                                                    
                            **Input:**
                            You will receive user insights under the key `user_activity_insight`, along with optional context such as:
                            - Preferred categories (e.g., fitness, wellness, creativity)
                            - Credit urgency (e.g., credits expiring soon)
                            - Location preferences or scheduling availability
                            - Historical booking patterns or cancellation trends
                                                    
                            Here is the behavioral insight:
                            {user_activity_insight}
                                                    
                            **Experience Context:**
                            - You have access to a catalog of experiences using the `getExperienceInfo(location)` tool.
                            - First, use this tool to fetch experiences available in the user's location (if known or inferred).
                            - Use these location-specific experiences as the source for your recommendations.
                                                    
                            **Weather Context:**
                            You also have access to live weather data via the `getCurrentWeather(city)` tool.
                            - After selecting experiences by location, use current weather conditions to filter or tailor recommendations.
                            - For outdoor experiences, check for rain, temperature, or poor conditions and offer indoor alternatives if needed.
                            - For pleasant weather, prioritize relevant outdoor or seasonal experiences.
                                                    
                            **Tool Usage Guidance:**
                            - Always call `getExperienceInfo(location)` before evaluating weather.
                            - Then use `getCurrentWeather(city)` to refine your final recommendations.
                                                    
                            **Your Task:**
                            Generate **1–3 personalized experience recommendations** that align with:
                            - The user's preferences, usage patterns, location, credit urgency
                            - The available experiences in that city
                            - Current weather conditions
                                                    
                            Your recommendations should be specific, engaging, and behaviorally aligned. For example:
                            - For under-utilized users: suggest trending or low-effort options to re-engage them.
                            - For active users: offer new categories or exclusive experiences in their area.
                            - If credits are expiring: prioritize high-impact, premium, or limited-time options.
                            - Use weather context to enhance seasonal relevance or avoid impractical suggestions.
                                                    
                            **Output Format:**
                            Respond with a single paragraph under the following heading:
                                                    
                            **recommendations:**
                            [Your personalized recommendations here]
                            """)
                .tools(FunctionTool.create(ExperienceMockDataTool.class, "getExperienceInfo"), FunctionTool.create(WeatherTool.class, "getCurrentWeather"))
                .build();
    }
}
