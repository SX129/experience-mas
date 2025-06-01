package com.experience.model.user;

import java.util.List;

public class Activity {
    private int bookingsLastMonth;
    private int cancellationsLastMonth;
    private List<String> preferredCategories;

    public Activity() {
    }

    public Activity(int bookingsLastMonth, int cancellationsLastMonth, List<String> preferredCategories) {
        this.bookingsLastMonth = bookingsLastMonth;
        this.cancellationsLastMonth = cancellationsLastMonth;
        this.preferredCategories = preferredCategories;
    }

    public int getBookingsLastMonth() {
        return bookingsLastMonth;
    }

    public void setBookingsLastMonth(int bookingsLastMonth) {
        this.bookingsLastMonth = bookingsLastMonth;
    }

    public int getCancellationsLastMonth() {
        return cancellationsLastMonth;
    }

    public void setCancellationsLastMonth(int cancellationsLastMonth) {
        this.cancellationsLastMonth = cancellationsLastMonth;
    }

    public List<String> getPreferredCategories() {
        return preferredCategories;
    }

    public void setPreferredCategories(List<String> preferredCategories) {
        this.preferredCategories = preferredCategories;
    }
}
