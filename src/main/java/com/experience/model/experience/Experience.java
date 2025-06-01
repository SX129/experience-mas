package com.experience.model.experience;

public class Experience {
    private String experienceId;
    private String title;
    private String category;
    private String location;
    private String description;
    private int creditCost;
    private boolean indoor;

    public Experience() {
    }

    public Experience(String experienceId, String title, String category, String location, String description, int creditCost, boolean indoor) {
        this.experienceId = experienceId;
        this.title = title;
        this.category = category;
        this.location = location;
        this.description = description;
        this.creditCost = creditCost;
        this.indoor = indoor;
    }

    public String getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(String experienceId) {
        this.experienceId = experienceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditCost() {
        return creditCost;
    }

    public void setCreditCost(int creditCost) {
        this.creditCost = creditCost;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }
}
