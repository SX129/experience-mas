package com.experience.agents;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.SequentialAgent;

public class RecommendationPipelineAgent {
    private static final String NAME = "recommendation_pipeline_agent";

    public static BaseAgent ROOT_AGENT = initAgent();

    private static BaseAgent initAgent() {
        return SequentialAgent.builder()
                .name(NAME)
                .description("Recommends personalized experiences for the user.")
                .subAgents(UserActivityAgent.ROOT_AGENT, RecommendationAgent.ROOT_AGENT)
                .build();
    }
}
