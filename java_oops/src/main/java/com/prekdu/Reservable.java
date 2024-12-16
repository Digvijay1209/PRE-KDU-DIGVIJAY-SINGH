package com.prekdu;

public interface Reservable {
    void reserve(LibraryMember member);
    void cancelReservation(LibraryMember member);
}