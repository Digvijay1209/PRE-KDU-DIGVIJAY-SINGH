package com.prekdu;

public class DigitalContent extends LibraryResource implements Renewable {
    private double fileSize; // to be considered in MB
    private ContentFormat format;

    public DigitalContent(String resourceId, String title, double fileSize, ContentFormat format) {
        super(resourceId, title);
        this.fileSize = fileSize;
        this.format = format;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        // I have considered late fee for digital content: INR 2 per day
        return daysLate * 2; 
    }

    @Override
    public int getMaxLoanPeriod() {
        //  I have considered max Loan period for digital content to be 1 week
        return 7; 
    }

    @Override
    public boolean renewLoan(LibraryMember member) {
        return true; // Digital content is renewable
    }
}