package com.experience.tools.mock;

import com.experience.model.experience.Experience;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.adk.tools.Annotations;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ExperienceMockDataTool {
    private static List<Experience> experiences;

    private static void loadMockData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream input = UserMockDataTool.class.getClassLoader().getResourceAsStream("mock/experiences.json");

            if(input == null){
                throw new RuntimeException("Mock data file not found: mock/experiences.json");
            }

            experiences = mapper.readValue(input,
                    mapper.getTypeFactory().constructCollectionType(List.class, Experience.class));

            System.out.println("Loaded " + experiences.size() + " experiences from mock data.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load mock experience data");
        }
    }

    private static List<Experience> getExperienceByLocation(String location) {
        if (experiences == null) {
            return Collections.emptyList();
        }

        return experiences.stream()
                .filter(exp -> exp.getLocation().equals(location))
                .collect(Collectors.toList());
    }

    public static Map<String, Object> getExperienceInfo(@Annotations.Schema(name = "location", description = "The location for which to retrieve experience info") String location){
        loadMockData();
        return Map.of("experiences", getExperienceByLocation(location));
    }
}
