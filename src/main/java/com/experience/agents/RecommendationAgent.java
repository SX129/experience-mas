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
                            You are a recommendation engine that suggests experiences for users based on their:
                            - Preferences (e.g., fitness, art, social)
                            - Credit urgency (e.g., credits expiring soon)
                            - Behavior (e.g., active, underutilized)
                            
                            Use the following user insight:
                            {user_activity_insight}

                            You may receive context like:
                            - Days until credits expire
                            - Preferred categories or locations
                            - Whether the user tends to cancel often
                            - Weather forecast (if provided)
                            
                            **Output:**
                            Tailor suggestions based on these inputs and return 1–3 personalized suggestions.
                        """)
                .tools(FunctionTool.create(RecommendationTools.class, "recommendExperiences"))
                .build();
    }
}
