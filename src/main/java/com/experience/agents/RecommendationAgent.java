package com.experience.agents;

import com.experience.tools.RecommendationTools;
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
                                                        
                            **Your Task:**
                            Using this information, generate **1–3 personalized experience recommendations** that align with the user’s preferences, usage patterns, and urgency.
                            Ensure your suggestions are relevant, compelling, and tailored to behavioral context. For example:
                            - For under-utilized users: suggest low-commitment or trending experiences to re-engage them.
                            - For highly active users: introduce fresh options in their favorite categories or nearby locations.
                            - If credits are near expiration: prioritize high-value or limited-time experiences.
                                                        
                            **Output Format:**
                            Respond with a single paragraph under the following heading:
                                                        
                            **recommendations:**
                            [Your personalized recommendations here]
                                                        
                            Do not include any other explanation, commentary, or headings.
                            """)
                .tools(FunctionTool.create(RecommendationTools.class, "recommendExperiences"))
                .build();
    }
}
