package com.movie.moviebookingservice.service;

import com.movie.moviebookingservice.model.City;
import com.movie.moviebookingservice.model.SelectedSeat;

import java.util.List;


public interface MovieBookingService {
    public List<City> getAllMoviesForAllCities();
    public SelectedSeat bookSelectedSeat(SelectedSeat selectedSeat);
}
