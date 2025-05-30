package com.experience.agents;

import com.experience.tools.UserActivityTools;
import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.FunctionTool;

public class UserActivityAgent {
    private static final String NAME = "user_activity_agent";

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name(NAME)
                .model("gemini-2.0-flash")
                .description("Analyzes user activity patterns to generate insights.")
                .instruction("""
                            You are an intelligent user behavior analyst. Your job is to generate actionable insights based on user activity data.

                            Evaluate:
                            - How many credits a user is using
                            - How frequently they book
                            - Whether they cancel often

                            Use this to identify behavioral patterns such as under-utilization, churn risk, or power users.
                            If under-utilized, suggest nudges or targeted offers.
                            If cancellations are high, suggest surveys or alternate class types.
                            """)
                .tools(FunctionTool.create(UserActivityTools.class, "analyzeUserActivity"))
                .outputKey("user_activity_insight")
                .build();
    }
}
