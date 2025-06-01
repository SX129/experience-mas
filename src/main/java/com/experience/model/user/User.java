package com.experience.model.user;

public class User {
    private String userId;
    private String name;
    private String location;
    private Account account;
    private Activity activity;
    private HistoricalPatterns historicalPatterns;

    public User() {}

    public User(String userId, String name, String location, Account account, Activity activity, HistoricalPatterns historicalPatterns) {
        this.userId = userId;
        this.name = name;
        this.location = location;
        this.account = account;
        this.activity = activity;
        this.historicalPatterns = historicalPatterns;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public HistoricalPatterns getHistoricalPatterns() {
        return historicalPatterns;
    }

    public void setHistoricalPatterns(HistoricalPatterns historicalPatterns) {
        this.historicalPatterns = historicalPatterns;
    }
}
