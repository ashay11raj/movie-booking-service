package com.movie.moviebookingservice.model;

import java.util.List;

public class Show {
    private String showName;
    private int showId;
    private List<Seat> seatList;

    public Show(String showName, int showId, List<Seat> seatList) {
        this.showName = showName;
        this.showId = showId;
        this.seatList = seatList;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
