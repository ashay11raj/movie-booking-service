package com.movie.moviebookingservice.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Seat {
    private int seatNumber;
    private String bookingStatus;
    private int bookingId;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        readLock.lock();
        try {
            return seatNumber;
        } finally {
            readLock.unlock();
        }
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getBookingStatus() {
        readLock.lock();
        try {
            return bookingStatus;
        } finally {
            readLock.unlock();
        }
    }

    public void setBookingStatus(String bookingStatus) {
        writeLock.lock();
        try{
            this.bookingStatus = bookingStatus;
        } finally {
            writeLock.unlock();
        }
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
}
