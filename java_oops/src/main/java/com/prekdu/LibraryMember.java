package com.prekdu;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String memberId;
    private MembershipType membershipType;
    private List<LibraryResource> borrowedResources;

    public LibraryMember(String memberId, MembershipType membershipType) {
        this.memberId = memberId;
        this.membershipType = membershipType;
        this.borrowedResources = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public List<LibraryResource> getBorrowedResources() {
        return borrowedResources;
    }

    public void borrowResource(LibraryResource resource) throws MaximumLoanExceededException, ResourceNotAvailableException {
        // I am considering the limit of borrowing resources for premium mebers to be 10 and for standard to be 5
        if (borrowedResources.size() >= (membershipType == MembershipType.PREMIUM ? 10 : 5)) {
            throw new MaximumLoanExceededException("Borrow limit exceeded.");
        }
        if (resource.getAvailabilityStatus() == ResourceStatus.BORROWED) {
            throw new ResourceNotAvailableException("Resource is not available.");
        }
        borrowedResources.add(resource);
        resource.setAvailabilityStatus(ResourceStatus.BORROWED);
    }

    public void returnResource(LibraryResource resource) {
        borrowedResources.remove(resource);
        resource.setAvailabilityStatus(ResourceStatus.AVAILABLE);
    }
}