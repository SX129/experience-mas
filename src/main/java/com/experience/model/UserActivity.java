package com.experience.model;

public class UserActivity {
    public String userId;
    public int creditsUsedLastMonth;
    public int activitiesBooked;
    public boolean oftenCancels;

    public UserActivity(String userId, int creditsUsedLastMonth, int activitiesBooked, boolean oftenCancels) {
        this.userId = userId;
        this.creditsUsedLastMonth = creditsUsedLastMonth;
        this.activitiesBooked = activitiesBooked;
        this.oftenCancels = oftenCancels;
    }

}
