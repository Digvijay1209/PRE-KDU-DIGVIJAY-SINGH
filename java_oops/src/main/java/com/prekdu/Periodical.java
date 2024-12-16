package com.prekdu;

public class Periodical extends LibraryResource implements Renewable, Reservable {
    private int issueNumber;
    private Frequency frequency;

    public Periodical(String resourceId, String title, int issueNumber, Frequency frequency) {
        super(resourceId, title);
        this.issueNumber = issueNumber;
        this.frequency = frequency;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        //Late fees for periodicals : INR 5 per day
        return daysLate * 5;
    }

    @Override
    public int getMaxLoanPeriod() {
        return frequency == Frequency.WEEKLY ? 7 : 30; // Weekly periodicals have a 7-day loan period, Monthly have 30
    }

    @Override
    public boolean renewLoan(LibraryMember member) {
        return true; 
    }

    @Override
    public void reserve(LibraryMember member) {
        if (availabilityStatus == ResourceStatus.BORROWED) {
            throw new IllegalStateException("Periodical is already borrowed");
        }
        availabilityStatus = ResourceStatus.RESERVED;
    }

    @Override
    public void cancelReservation(LibraryMember member) {
        if (availabilityStatus == ResourceStatus.RESERVED) {
            availabilityStatus = ResourceStatus.AVAILABLE;
        }
    }
}