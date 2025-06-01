package com.experience.tools.user;

import com.experience.model.user.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.adk.tools.Annotations;

import java.util.Map;
import java.util.Optional;
import java.io.File;

public class UserMockDataTool {
    private static List<User> users;

    private static void loadMockData() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream input = UserMockDataTool.class.getClassLoader().getResourceAsStream("mock/users.json");

            if(input == null){
                throw new RuntimeException("Mock data file not found: mock/users.json");
            }

            users = mapper.readValue(input,
                    mapper.getTypeFactory().constructCollectionType(List.class, User.class));

            System.out.println("Loaded " + users.size() + " users from mock data.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load mock user data");
        }
    }

    private static Optional<User> getUserById(String userId) {
        if (users == null) {
            return Optional.empty();
        }
        return users.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst();
    }

    public static Map<String, Object> getUserInfo(@Annotations.Schema(name = "userId", description = "The id of the user for which to retrieve info") String userId){
        loadMockData();
        return Map.of("user", getUserById(userId));
    }
}
