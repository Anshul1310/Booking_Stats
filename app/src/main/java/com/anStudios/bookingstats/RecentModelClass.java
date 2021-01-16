package com.anStudios.bookingstats;

public class RecentModelClass {
    private String photoUrl;
    private String customerName;
    private String bookingTime;
    private String bookingFrom;
    private String bookingTo;


    public RecentModelClass(String photoUrl, String customerName, String bookingTime, String bookingFrom, String bookingTo) {
        this.photoUrl = photoUrl;
        this.customerName = customerName;
        this.bookingTime = bookingTime;
        this.bookingFrom = bookingFrom;
        this.bookingTo = bookingTo;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingFrom() {
        return bookingFrom;
    }

    public void setBookingFrom(String bookingFrom) {
        this.bookingFrom = bookingFrom;
    }

    public String getBookingTo() {
        return bookingTo;
    }

    public void setBookingTo(String bookingTo) {
        this.bookingTo = bookingTo;
    }
}
