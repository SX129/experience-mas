package com.experience.model.user;

public class Account {
    private int creditsAvailable;
    private int lastCreditExpirationDays;

    public Account() {
    }

    public Account(int creditsAvailable, int lastCreditExpirationDays) {
        this.creditsAvailable = creditsAvailable;
        this.lastCreditExpirationDays = lastCreditExpirationDays;
    }

    public int getCreditsAvailable() {
        return creditsAvailable;
    }

    public void setCreditsAvailable(int creditsAvailable) {
        this.creditsAvailable = creditsAvailable;
    }

    public int getLastCreditExpirationDays() {
        return lastCreditExpirationDays;
    }

    public void setLastCreditExpirationDays(int lastCreditExpirationDays) {
        this.lastCreditExpirationDays = lastCreditExpirationDays;
    }
}
