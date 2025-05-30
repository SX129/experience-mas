package com.experience;

import com.experience.agents.CoordinatorAgent;
import com.google.adk.events.Event;
import com.google.adk.runner.InMemoryRunner;
import com.google.adk.sessions.Session;
import com.google.genai.types.Content;
import com.google.genai.types.Part;
import io.reactivex.rxjava3.core.Flowable;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        InMemoryRunner runner = new InMemoryRunner(CoordinatorAgent.ROOT_AGENT);

        Session session =
                runner
                        .sessionService()
                        .createSession(CoordinatorAgent.NAME, CoordinatorAgent.USER_ID)
                        .blockingGet();

        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            while (true) {
                System.out.print("\nInput:  ");
                String userInput = scanner.nextLine();

                if ("quit".equalsIgnoreCase(userInput)) {
                    break;
                }

                Content message = Content.fromParts(Part.fromText(userInput));
                Flowable<Event> events = runner.runAsync(CoordinatorAgent.USER_ID, session.id(), message);

                System.out.print("\nAgent: ");
                events.blockingForEach(event -> System.out.println(event.stringifyContent()));
            }
        }
    }
}
