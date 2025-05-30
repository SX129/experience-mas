package com.experience.agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;

public class CoordinatorAgent {
    public static final String NAME = "coordinator_agent";
    public static final String USER_ID = "dev_user";

    public static BaseAgent ROOT_AGENT = initAgent();

    public static BaseAgent initAgent(){
        return LlmAgent.builder()
            .name(NAME)
            .model("gemini-2.0-flash")
            .description("Coordinates multi-agent workflows and routes tasks to the appropriate agent.")
            .instruction("""
                You are the orchestrator in a multi-agent system.
                
                You must understand the user request and decide whether to:
                - Route to the User Activity Agent
                - Route to the Credit Optimization Agent
                - Handle it yourself (if generic or trivial)
                
                If a request is about behavior, usage, cancellations, or patterns, delegate to the UserActivityAgent.
                If a request is about maximizing credits, credit status, or savings, delegate to the CreditOptimizationAgent.
                
                Return the result clearly and briefly. Don't fabricate data — only respond based on the tools and agents available to you.
                """)
            .subAgents(CreditOptimizationAgent.initAgent(), UserActivityAgent.initAgent())
            .build();
    }
}