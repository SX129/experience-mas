package com.experience.model.user;

public class HistoricalPatterns {
    private double bookingFrequencyPerWeek;
    private double cancellationRate;

    public HistoricalPatterns() {
    }

    public HistoricalPatterns(double bookingFrequencyPerWeek, double cancellationRate) {
        this.bookingFrequencyPerWeek = bookingFrequencyPerWeek;
        this.cancellationRate = cancellationRate;
    }

    public double getBookingFrequencyPerWeek() {
        return bookingFrequencyPerWeek;
    }

    public void setBookingFrequencyPerWeek(double bookingFrequencyPerWeek) {
        this.bookingFrequencyPerWeek = bookingFrequencyPerWeek;
    }

    public double getCancellationRate() {
        return cancellationRate;
    }

    public void setCancellationRate(double cancellationRate) {
        this.cancellationRate = cancellationRate;
    }
}
