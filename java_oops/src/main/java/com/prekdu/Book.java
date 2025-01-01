package com.prekdu;

public class Book extends LibraryResource implements Renewable, Reservable {

  @SuppressWarnings("unused")
  private String author;

  @SuppressWarnings("unused")
  private String isbn;

  public Book(String resourceId, String title, String author, String isbn) {
    super(resourceId, title);

    this.author = author;
    this.isbn = isbn;
  }

  @Override
  public double calculateLateFee(int daysLate) {
    // I Have considered late fees to be INR 0.5  per day
    return daysLate * 0.5;
  }

  @Override
  public int getMaxLoanPeriod() {
    // I have considered max loan period to be 2 weeks or 14 days
    return 14;
  }

  @Override
  public boolean renewLoan(LibraryMember member) {
    return availabilityStatus != ResourceStatus.BORROWED;
  }

  @Override
  public void reserve(LibraryMember member) throws IllegalStateException {
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
