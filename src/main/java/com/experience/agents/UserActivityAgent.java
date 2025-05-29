package com.experience.agents;

import com.experience.tools.UserActivityTools;
import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.FunctionTool;

public class UserActivityAgent {
    public static final String NAME = "user_activity_agent";
    public static final String USER_ID = "dev_user";

    public static BaseAgent ROOT_AGENT = initAgent();

    public static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name(NAME)
                .model("gemini-2.0-flash")
                .description("Analyzes user activity patterns to generate insights.")
                .instruction("You are a helpful behavior analysis agent that generates insights based on user credit usage and behavior.")
                .tools(FunctionTool.create(UserActivityTools.class, "analyzeUserActivity"))
                .build();
    }


}
