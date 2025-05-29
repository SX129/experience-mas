package com.experience.model;

public class UserActivity {
    private String userId;
    private int creditsUsedLastMonth;
    private int activitiesBooked;
    private boolean oftenCancels;

    public UserActivity(String userId, int creditsUsedLastMonth, int activitiesBooked, boolean oftenCancels) {
        this.userId = userId;
        this.creditsUsedLastMonth = creditsUsedLastMonth;
        this.activitiesBooked = activitiesBooked;
        this.oftenCancels = oftenCancels;
    }


}
