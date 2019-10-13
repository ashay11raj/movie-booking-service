package com.movie.moviebookingservice.model;

import java.util.List;

public class City {
    private String cityName;
    private int cityId;
    private List<Theater> theaterList;

    public City(String cityName, int cityId, List<Theater> theaterList) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.theaterList = theaterList;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public List<Theater> getTheaterList() {
        return theaterList;
    }

    public void setTheaterList(List<Theater> theaterList) {
        this.theaterList = theaterList;
    }
}
