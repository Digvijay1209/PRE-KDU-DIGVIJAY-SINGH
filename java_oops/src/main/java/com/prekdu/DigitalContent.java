package com.prekdu;

public class DigitalContent extends LibraryResource implements Renewable {

  @SuppressWarnings("unused")
  private double fileSize;

  @SuppressWarnings("unused")
  ContentFormat format;

  public DigitalContent(String resourceId, String title, double fileSize, ContentFormat format) {
    super(resourceId, title);

    this.fileSize = fileSize;
    this.format = format;
  }

  @Override
  public double calculateLateFee(int daysLate) {
    return daysLate * 0.25; // Example: late fee rate is 0.25 per day
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
