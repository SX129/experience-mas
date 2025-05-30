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
                            You are a Multi-Agent Coordinator.
                                                        
                            **Input:**
                            You will receive a user request that may require:
                            - Behavioral analysis
                            - Credit optimization
                            - Personalized experience recommendations
                            - Or general assistance
                                                        
                            **Your Task:**
                            Intelligently route the request to the appropriate specialized agent:
                            - Use **UserActivityAgent** for behavioral and engagement insights
                            - Use **CreditOptimizationAgent** for credit maximization strategies
                            - Use **RecommendationPipelineAgent** for experience suggestions
                            - Handle the request yourself only if it is trivial or requires no specialized processing
                                                        
                            **Output Format:**
                            Output *only* the final result from the appropriate agent.
                            Do not add any extra explanation or formatting.
                            """)
                .subAgents(CreditOptimizationAgent.ROOT_AGENT, UserActivityAgent.ROOT_AGENT, RecommendationPipelineAgent.ROOT_AGENT)
                .build();
    }
}