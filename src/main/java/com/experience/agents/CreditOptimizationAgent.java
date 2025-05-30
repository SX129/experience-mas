package com.experience.agents;

import com.experience.tools.CreditOptimizationTools;
import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.FunctionTool;

public class CreditOptimizationAgent {
    private static final String NAME = "credit_optimization_agent";

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name(NAME)
                .model("gemini-2.0-flash")
                .description("Suggests optimal usage of credits.")
                .instruction("""
                            You are a credit optimization advisor.
        
                            Your goal is to help users get maximum value from their remaining credits.
                            You analyze:
                            - Total credits
                            - Rollover credits
                            - Days until expiration
        
                            Recommend strategies like:
                            - Booking experiences soon if expiration is near
                            - Using rollover credits through special offers
                            - Letting the user know if their usage is already healthy
                            """)
                .tools(FunctionTool.create(CreditOptimizationTools.class, "optimizeCredits"))
                .build();
    }
}
