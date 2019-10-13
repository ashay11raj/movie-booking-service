package com.movie.moviebookingservice.model;

import java.util.List;

public class Theater {
    private String theaterName;
    private int theaterId;
    private List<Show> showList;

    public Theater(String theaterName, int theaterId, List<Show> showList) {
        this.theaterName = theaterName;
        this.theaterId = theaterId;
        this.showList = showList;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }
}
