package com.prekdu;

public abstract class LibraryResource {
    protected String resourceId;
    protected String title;
    protected ResourceStatus availabilityStatus;

    public LibraryResource(String resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;
        this.availabilityStatus = ResourceStatus.AVAILABLE;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public ResourceStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(ResourceStatus status) {
        this.availabilityStatus = status;
    }

    public abstract double calculateLateFee(int daysLate);
    public abstract int getMaxLoanPeriod();
}