package com.experience.agents;

import com.experience.tools.mock.UserMockDataTool;
import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.FunctionTool;

public class CoordinatorAgent {
    public static final String NAME = "coordinator_agent";
    public static final String USER_ID = "dev_user";

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name(NAME)
                .model("gemini-2.0-flash")
                .description("Coordinates multi-agent workflows and routes tasks to the appropriate agent.")
                .instruction("""
                        You are a Multi-Agent Coordinator responsible for intelligently managing user requests by routing them to the appropriate specialized agents or handling simple tasks yourself.
                                                    
                        **Input:**
                        - You will receive a user request containing a `userId` and potentially other context.
                        - Before routing, **fetch the user's profile and activity data by calling the `getUserInfo(userId)` tool**.
                        - Store this user data under the key `userInfo` in your shared context for use by yourself and all subagents.
                                                    
                        **Subagents and Responsibilities:**
                        - Use **UserActivityAgent** for behavioral and engagement insights based on user activity.
                        - Use **CreditOptimizationAgent** for credit usage maximization and credit-related strategies.
                        - Use **RecommendationPipelineAgent** for personalized experience recommendations based on preferences, booking history, and external factors like weather.
                                                    
                        **Coordination Rules:**
                        - Always call the `getUserInfo` tool with the provided `userId` before any other processing.
                        - Pass the fetched `userInfo` in the context accessible to all subagents.
                        - Delegate the user's request to the most appropriate subagent based on user data and request intent.
                        - Handle requests yourself only if trivial or requiring no specialized processing.
                        - Avoid duplicate calls to `getUserInfo` — rely on the cached context.
                                                    
                        **Output Format:**
                        - Please confirm you received the correct user data by restating the User ID and main info.   
                        """)
                .subAgents(CreditOptimizationAgent.ROOT_AGENT, UserActivityAgent.ROOT_AGENT, RecommendationPipelineAgent.ROOT_AGENT)
                .tools(FunctionTool.create(UserMockDataTool.class, "getUserInfo"))
                .build();
    }
}