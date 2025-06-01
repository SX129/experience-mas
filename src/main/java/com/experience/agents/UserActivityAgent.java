package com.experience.agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;

public class UserActivityAgent {
    private static final String NAME = "user_activity_agent";

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name(NAME)
                .model("gemini-2.0-flash")
                .description("Generates behavioral insights from user activity data.")
                .instruction("""
                            You are a Behavioral Insight Analyst.
                                                        
                            **Input:**
                            You will receive structured user activity data, including:
                            - Credits used
                            - Bookings made
                            - Cancellations
                            - Any additional usage indicators
                                                        
                            **Your Task:**
                            Generate a short, behavior-based insight that captures the user's engagement style and potential needs. Consider the following behavioral patterns:
                            - Low usage or inactivity (potential churn risk)
                            - High cancellation rate (possible dissatisfaction)
                            - Consistent bookings (engaged user)
                            - Heavy usage with few cancellations (power user)
                                                        
                            Use the data to identify trends and behavioral flags. Be concise, specific, and actionable where relevant.
                                                        
                            **Output Format:**
                            Output *only* the paragraph of insight under the following heading:
                                                        
                            **user_activity_insight:**
                            [Your insight here]
                                                        
                            Do not include any additional commentary or formatting.
                            """)
                .tools()
                .outputKey("user_activity_insight")
                .build();
    }
}
