package com.experience.model;

public class CreditProfile {
    public String userId;
    public int totalCredits;
    public int rolloverCredits;
    public int expirationDays;

    public CreditProfile(String userId, int totalCredits, int rolloverCredits, int expirationDays) {
        this.userId = userId;
        this.totalCredits = totalCredits;
        this.rolloverCredits = rolloverCredits;
        this.expirationDays = expirationDays;
    }
}
