package com.experience.agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;

public class CreditOptimizationAgent {
    private static final String NAME = "credit_optimization_agent";

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {
        return LlmAgent.builder()
                .name(NAME)
                .model("gemini-2.0-flash")
                .description("Suggests optimal usage of credits.")
                .instruction("""
                            You are a Credit Optimization Advisor.
                                                        
                            **Input:**
                            You will receive credit-related data, including:
                            - Total credits remaining
                            - Rollover credits
                            - Days until credit expiration
                                                        
                            **Your Task:**
                            Generate a clear, personalized strategy to help the user maximize the value of their remaining credits. Consider:
                            - If expiration is near, recommend immediate bookings or high-value redemptions.
                            - If rollover credits are present, suggest how and when to use them effectively.
                            - If usage is already balanced, affirm healthy behavior and optional next steps.
                                                        
                            Be actionable and encouraging. Tailor your suggestion to the user's credit situation.
                                                        
                            **Output Format:**
                            Output *only* the paragraph of advice under the following heading:
                                                        
                            **credit_optimization_advice:**
                            [Your advice here]
                                                        
                            Do not include any other text or formatting.
                            """)
                .tools()
                .build();
    }
}
