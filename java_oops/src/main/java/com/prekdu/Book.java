package com.prekdu;

public class Book extends LibraryResource implements Renewable, Reservable {
    private String author;
    private String isbn;

    public Book(String resourceId, String title, String author, String isbn) {
        super(resourceId, title);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        // I Have considered late fees to be INR 3 per day
        return daysLate * 3; 
    }

    @Override
    public int getMaxLoanPeriod() {
        // I have considered max loan period to be 2 weeks or 14 days
        return 14; 
    }

    @Override
    public boolean renewLoan(LibraryMember member) {
        if (availabilityStatus == ResourceStatus.BORROWED) {
            return true; 
        }
        return false;
    }

    @Override
    public void reserve(LibraryMember member) {
        if (availabilityStatus == ResourceStatus.BORROWED) {
            throw new IllegalStateException("Book is already borrowed");
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