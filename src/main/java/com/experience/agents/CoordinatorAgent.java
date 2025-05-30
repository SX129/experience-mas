package com.experience.agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;

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
                            You are the orchestrator in a multi-agent system.
    
                            Route requests as follows:
                            - To UserActivityAgent for behavior/cancellation/usage insights
                            - To CreditOptimizationAgent for maximizing credits
                            - To RecommendationPipelineAgent for personalized experience suggestions
                            - Handle it yourself (if generic or trivial)
                            
                            Return the result clearly and briefly. Don't fabricate data — only respond based on the tools and agents available to you.
                            """)
                .subAgents(CreditOptimizationAgent.ROOT_AGENT, UserActivityAgent.ROOT_AGENT, RecommendationPipelineAgent.ROOT_AGENT)
                .build();
    }
}